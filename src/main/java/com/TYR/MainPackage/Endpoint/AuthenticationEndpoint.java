package com.TYR.MainPackage.Endpoint;

import com.TYR.MainPackage.Model.DataTransferObject.AuthRequest;
import com.TYR.MainPackage.Model.Response.GeneralResponse;
import com.TYR.MainPackage.Model.Response.LoginResponse;
import com.TYR.MainPackage.Model.Response.RegisterResponse;
import com.TYR.MainPackage.Service.AuthService;
import com.TYR.MainPackage.Strings.EndpointPath;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(EndpointPath.AUTH)
@RequiredArgsConstructor
public class AuthenticationEndpoint {
    private final AuthService authService;
    @PostMapping(EndpointPath.REGISTER)
    public ResponseEntity<?> registerCustomer(@RequestBody AuthRequest authRequest){
        RegisterResponse registerResponse = authService.registerUser(authRequest);

        GeneralResponse<RegisterResponse> response = GeneralResponse.<RegisterResponse>builder()
                .message("Successfully register new Member !")
                .status(HttpStatus.CREATED.value())
                .data(registerResponse)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping(EndpointPath.LOGIN)
    public ResponseEntity<?> loginUser(@RequestBody AuthRequest authRequest){
        LoginResponse loginResponse = authService.loginUser(authRequest);

        GeneralResponse<LoginResponse> response = GeneralResponse.<LoginResponse>builder()
                .message("Found associated account")
                .status(HttpStatus.ACCEPTED.value())
                .data(loginResponse)
                .build();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

//    @RolesAllowed("ROLE_OWNER")
    @PostMapping(EndpointPath.SUPER + EndpointPath.REGISTER)
    public ResponseEntity<?> registerSuperUser(@RequestBody AuthRequest authRequest){
        RegisterResponse registerResponse = authService.registerSuperUser(authRequest);

        GeneralResponse<RegisterResponse> response = GeneralResponse.<RegisterResponse>builder()
                .message("Successfully register new Member !")
                .status(HttpStatus.CREATED.value())
                .data(registerResponse)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/test")
    public String test(){
        System.out.println("test auth ?");
        return "TEST";
    }
}