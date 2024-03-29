package com.TYR.MainPackage.Service.Implementator;

import com.TYR.MainPackage.Model.DataTransferObject.AuthRequest;
import com.TYR.MainPackage.Model.Entity.AppUser;
import com.TYR.MainPackage.Model.Entity.Customer;
import com.TYR.MainPackage.Model.Entity.Role;
import com.TYR.MainPackage.Model.Entity.User;
import com.TYR.MainPackage.Model.Response.LoginResponse;
import com.TYR.MainPackage.Model.Response.RegisterResponse;
import com.TYR.MainPackage.Repository.UserRepository;
import com.TYR.MainPackage.Security.JwtUtil;
import com.TYR.MainPackage.Service.AuthService;
import com.TYR.MainPackage.Service.CustomerService;
import com.TYR.MainPackage.Service.RoleService;
import com.TYR.MainPackage.Strings.Enums.MembershipTier;
import com.TYR.MainPackage.Strings.Enums.RoleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthServiceImplementator implements AuthService {
    private final RoleService roleService;
    private final CustomerService customerService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    @Override
    public RegisterResponse registerUser(AuthRequest authRequest) {
        try {
            Role role = roleService.assignRole(RoleEnum.ROLE_MEMBER);
            User user = User.builder()
                    .username(authRequest.getUsername())
                    .password(passwordEncoder.encode(authRequest.getPassword()))
                    .role(role)
                    .build();
            userRepository.save(user);

            Customer customer = Customer.builder()
                    .name(authRequest.getName())
                    .email(authRequest.getEmail())
                    .phone(authRequest.getPhone())
                    .address(authRequest.getAddress())
                    .tier(MembershipTier.BRONZE)
                    .user(user)
                    .points(0L)
                    .build();
            customerService.saveMember(customer);

            return RegisterResponse.builder()
                    .username(authRequest.getUsername())
                    .email(authRequest.getEmail())
                    .role(String.valueOf(RoleEnum.ROLE_MEMBER))
                    .build();
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email / User already exist !");
        }
    }

    @Override
    public RegisterResponse registerSuperUser(AuthRequest authRequest) {
        try {
            Role role = switch (authRequest.getUserType()) {
                case 1 -> roleService.assignRole(RoleEnum.ROLE_MEMBER);
                case 2 -> roleService.assignRole(RoleEnum.ROLE_STAFF);
                case 3 -> roleService.assignRole(RoleEnum.ROLE_ADMIN);
                case 4 -> roleService.assignRole(RoleEnum.ROLE_OWNER);
                default -> roleService.assignRole(RoleEnum.ROLE_GUEST);
            };
            // 0 = Guest, 1 = Member, 2 = Staff, 3 = Admin, 4 = Owner
            User user = User.builder()
                    .username(authRequest.getUsername())
                    .password(passwordEncoder.encode(authRequest.getPassword()))
                    .role(role)
                    .build();
            userRepository.save(user);

            Customer customer = Customer.builder()
                    .name(authRequest.getName())
                    .email(authRequest.getEmail())
                    .phone(authRequest.getPhone())
                    .address(authRequest.getAddress())
                    .tier(MembershipTier.BRONZE)
                    .user(user)
                    .points(0L)
                    .build();
            customerService.saveMember(customer);

            return RegisterResponse.builder()
                    .username(authRequest.getUsername())
                    .email(authRequest.getEmail())
                    .role(String.valueOf(role.getName()))
                    .build();
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email / User already exist !");
        }
    }

    @Override
    public LoginResponse loginUser(AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),
                        authRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        AppUser appUser = (AppUser) authentication.getPrincipal();
        String token = jwtUtil.generatedToken(appUser);

        // Check membership tier
        Customer customer = customerService.getCustomerData(appUser.getUserId());

        switch (customer.getTransactionCount()){
            case 25: customer.setTier(MembershipTier.SILVER);
                break;
            case 75: customer.setTier(MembershipTier.GOLD);
                break;
            case 150: customer.setTier(MembershipTier.PLATINUM);
                break;
            case 250: customer.setTier(MembershipTier.DIAMOND);
                break;
            default: customer.setTier(MembershipTier.BRONZE);
        } customerService.saveMember(customer);

        return LoginResponse.builder()
                .username(authRequest.getUsername())
                .role(appUser.getRole().name())
                .token(token)
                .build();
    }
}