package com.TYR.MainPackage.Service;

import com.TYR.MainPackage.Model.DataTransferObject.CustomerUpdate;
import com.TYR.MainPackage.Model.DataTransferObject.GetUserDTO;
import com.TYR.MainPackage.Model.Entity.Customer;

public interface CustomerService {
    void saveMember(Customer customer);
    GetUserDTO getMemberData(String id);
    Customer getCustomerData(String id);
    void updateMemberData(String id, CustomerUpdate customerUpdate);
    void deleteMember(String id);
}
