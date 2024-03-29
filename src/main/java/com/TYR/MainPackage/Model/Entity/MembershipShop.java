package com.TYR.MainPackage.Model.Entity;

import com.TYR.MainPackage.Strings.Enums.ItemType;
import com.TYR.MainPackage.Strings.Enums.MembershipTier;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "member_shop")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MembershipShop {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private ItemType type;
    private int price;
    private String description;
    private int stock;
    private MembershipTier tier;
}