package com.TYR.MainPackage.Service.Implementator;

import com.TYR.MainPackage.Model.Entity.Role;
import com.TYR.MainPackage.Repository.RoleRepository;
import com.TYR.MainPackage.Service.RoleService;
import com.TYR.MainPackage.Strings.Enums.RoleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImplementator implements RoleService {
    private final RoleRepository roleRepository;
    @Override
    public Role assignRole(RoleEnum roleEnum) {
//        Role role = roleRepository.findByrole(roleEnum);
        Role role = Role.builder()
                .name(roleEnum)
                .build();

        return roleRepository.save(role);
    }
}