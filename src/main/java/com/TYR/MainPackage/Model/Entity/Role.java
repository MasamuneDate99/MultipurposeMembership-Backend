package com.TYR.MainPackage.Model.Entity;

import com.TYR.MainPackage.Strings.Enums.RoleEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "master_role")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private RoleEnum name;
}