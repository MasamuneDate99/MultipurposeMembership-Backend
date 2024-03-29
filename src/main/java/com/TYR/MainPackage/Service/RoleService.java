package com.TYR.MainPackage.Service;

import com.TYR.MainPackage.Model.Entity.Role;
import com.TYR.MainPackage.Strings.Enums.RoleEnum;

public interface RoleService {
    Role assignRole(RoleEnum roleEnum);
}
