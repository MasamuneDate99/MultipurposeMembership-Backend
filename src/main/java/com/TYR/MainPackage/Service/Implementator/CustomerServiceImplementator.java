package com.TYR.MainPackage.Service.Implementator;

import com.TYR.MainPackage.Model.DataTransferObject.CustomerUpdate;
import com.TYR.MainPackage.Model.DataTransferObject.GetUserDTO;
import com.TYR.MainPackage.Model.Entity.Customer;
import com.TYR.MainPackage.Repository.CustomerRepository;
import com.TYR.MainPackage.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImplementator implements CustomerService {
    private final CustomerRepository customerRepository;
    @Override
    public void saveMember(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public GetUserDTO getMemberData(String id) {
//        Customer customer = customerRepository.findByuser_id(id);
        Customer customer = customerRepository.nativeFindById(id);
        return GetUserDTO.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .address(customer.getAddress())
                .transactionCount(customer.getTransactionCount())
                .points(customer.getPoints())
                .tier(customer.getTier())
                .build();
    }

    @Override
    public Customer getCustomerData(String id) {
        return customerRepository.findByuser_id(id);
    }

    @Override
    public void updateMemberData(String id, CustomerUpdate customerUpdate) {
        if(customerRepository.nativeFindById(id) != null) {
//            return customerRepository.save(customer);
            customerRepository.nativeUpdateCustomerData(
                    customerUpdate.getAddress(),
                    customerUpdate.getEmail(),
                    customerUpdate.getName(),
                    customerUpdate.getPhone(),
                    id
            );
        }
        else throw new DataRetrievalFailureException("User not found !");
    }

    @Override
    public void deleteMember(String id) {
        if (customerRepository.existsById(id)){
            customerRepository.deleteById(id);
        } else throw new DataRetrievalFailureException("User not found !");
    }
}