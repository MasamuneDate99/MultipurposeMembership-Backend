package com.TYR.MainPackage.Service;

import com.TYR.MainPackage.Model.DataTransferObject.AuthRequest;
import com.TYR.MainPackage.Model.Response.LoginResponse;
import com.TYR.MainPackage.Model.Response.RegisterResponse;

public interface AuthService {
    RegisterResponse registerUser(AuthRequest authRequest);
    RegisterResponse registerSuperUser(AuthRequest authRequest);
    LoginResponse loginUser(AuthRequest authRequest);

}