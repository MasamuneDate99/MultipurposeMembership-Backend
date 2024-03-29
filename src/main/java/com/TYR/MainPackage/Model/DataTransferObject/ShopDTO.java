package com.TYR.MainPackage.Model.DataTransferObject;

import com.TYR.MainPackage.Strings.Enums.ItemType;
import com.TYR.MainPackage.Strings.Enums.MembershipTier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ShopDTO {
    private int itemType;
    private int price;
    private String description;
    private int stock;
    private int memberTier;
}