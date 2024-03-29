package com.TYR.MainPackage.Model.DataTransferObject;

import com.TYR.MainPackage.Strings.Enums.MembershipTier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class BenefitDTO<T> {
    private String id;
    private String name;
    private String description;
    private String shortDescription;
    private MembershipTier tier;
    private T progressData;
}
