package com.TYR.MainPackage.Model.Entity;

import com.TYR.MainPackage.Strings.Enums.MembershipTier;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "master_customer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String address;
    private int transactionCount = 0;
    private Long points = 0L;
    private MembershipTier tier;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}