package com.TYR.MainPackage.Repository;

import com.TYR.MainPackage.Model.Entity.Role;
import com.TYR.MainPackage.Strings.Enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
//    Role findByrole(RoleEnum roleEnum);
}