package com.TYR.MainPackage.Repository;

import com.TYR.MainPackage.Model.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    Customer findByuser_id(String id);

    @Query(
            nativeQuery = true,
            value = "SELECT * From master_customer WHERE user_id=:param")
    Customer nativeFindById(@Param("param") String id);

    @Query(
            nativeQuery = true,
            value = "UPDATE master_customer SET address=:A, email=:B, name=:C, phone=:D WHERE user_id=:id")
    void nativeUpdateCustomerData(@Param("A") String address,@Param("B") String email,@Param("C") String name,@Param("D") String phone,@Param("id") String id);
}