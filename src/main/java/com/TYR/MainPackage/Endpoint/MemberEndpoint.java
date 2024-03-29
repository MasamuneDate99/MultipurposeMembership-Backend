package com.TYR.MainPackage.Endpoint;

import com.TYR.MainPackage.Model.DataTransferObject.AuthRequest;
import com.TYR.MainPackage.Model.DataTransferObject.CustomerUpdate;
import com.TYR.MainPackage.Model.DataTransferObject.GetUserDTO;
import com.TYR.MainPackage.Model.DataTransferObject.ShopDTO;
import com.TYR.MainPackage.Model.Entity.AppUser;
import com.TYR.MainPackage.Model.Entity.Customer;
import com.TYR.MainPackage.Model.Entity.MembershipShop;
import com.TYR.MainPackage.Model.Response.GeneralResponse;
import com.TYR.MainPackage.Model.Response.ListResponse;
import com.TYR.MainPackage.Security.JwtUtil;
import com.TYR.MainPackage.Service.CustomerService;
import com.TYR.MainPackage.Service.MemberShopService;
import com.TYR.MainPackage.Strings.EndpointPath;
import com.TYR.MainPackage.Strings.Enums.MembershipTier;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(EndpointPath.MEMBER)
@RequiredArgsConstructor
public class MemberEndpoint {
    private final CustomerService customerService;
    private final MemberShopService memberShopService;
    private String getUserInfo(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AppUser appUser = (AppUser) auth.getPrincipal();
        return appUser.getUserId();
    }

    private void refreshMembershipTier(){
        String userId = getUserInfo();
        Customer customer = customerService.getCustomerData(userId);

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
    }

    private void refreshMissionReward(){

    }

    @GetMapping
    public ResponseEntity<?> getMemberData(@AuthenticationPrincipal AppUser appUser){
        String userId = getUserInfo();
        GetUserDTO getUserDTO = customerService.getMemberData(userId);
        GeneralResponse<GetUserDTO> response = GeneralResponse.<GetUserDTO>builder()
                .data(getUserDTO)
                .message("Found user data")
                .status(HttpStatus.ACCEPTED.value())
                .build();
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @PutMapping
    public ResponseEntity<?> updateMemberData(@RequestBody CustomerUpdate customerUpdate){
        String userId = getUserInfo();
        customerService.updateMemberData(userId, customerUpdate);
        GeneralResponse<GetUserDTO> response = GeneralResponse.<GetUserDTO>builder()
                .message("Found user data")
                .data(customerService.getMemberData(userId))
                .status(HttpStatus.ACCEPTED.value())
                .build();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteMember(){
        String userId = getUserInfo();
        customerService.deleteMember(userId);
        GeneralResponse<String> response = GeneralResponse.<String>builder()
                .data("Delete user with ID : " + userId)
                .message("Found user data")
                .status(HttpStatus.ACCEPTED.value())
                .build();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @GetMapping(EndpointPath.REFRESH)
    public GeneralResponse<Customer> updateAllStatus(){
        String userId = getUserInfo();

        refreshMembershipTier();

        Customer customer = customerService.getCustomerData(userId);
        return GeneralResponse.<Customer>builder()
                .data(customer)
                .message("Successfully refresh member data")
                .status(HttpStatus.OK.value())
                .build();
    }

    @GetMapping(EndpointPath.SHOP)
    public ResponseEntity<ListResponse<MembershipShop>> getAllItem(){
        String userId = getUserInfo();
        List<MembershipShop> response = memberShopService.getAllItem(userId);
        
        ListResponse<MembershipShop> listResponse = ListResponse.<MembershipShop>builder()
                .message("Fetching all item data")
                .data(response)
                .build();
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(listResponse);
    }
}