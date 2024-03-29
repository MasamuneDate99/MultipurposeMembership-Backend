package com.TYR.MainPackage.Model.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "master_user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;

    @OneToOne
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_userId"),
            inverseJoinColumns = @JoinColumn(name = "role_roleid")
    )
    Role role;
}