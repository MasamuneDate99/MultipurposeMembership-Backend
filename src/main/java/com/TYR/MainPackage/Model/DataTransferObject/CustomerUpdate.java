package com.TYR.MainPackage.Model.DataTransferObject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerUpdate {
    private String name;
    private String email;
    private String phone;
    private String address;
}
