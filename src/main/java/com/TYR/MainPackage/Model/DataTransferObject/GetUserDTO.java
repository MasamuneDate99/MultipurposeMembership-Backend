package com.TYR.MainPackage.Model.DataTransferObject;

import com.TYR.MainPackage.Strings.Enums.MembershipTier;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class GetUserDTO {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private int transactionCount;
    private Long points;
    private MembershipTier tier;
}