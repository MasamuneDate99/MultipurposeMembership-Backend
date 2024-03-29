package com.TYR.MainPackage.Service.Implementator;

import com.TYR.MainPackage.Model.DataTransferObject.NewRequest;
import com.TYR.MainPackage.Model.DataTransferObject.ShopDTO;
import com.TYR.MainPackage.Model.Entity.Customer;
import com.TYR.MainPackage.Model.Entity.MembershipShop;
import com.TYR.MainPackage.Model.Response.NewEntryResponse;
import com.TYR.MainPackage.Repository.MemberShop;
import com.TYR.MainPackage.Service.CustomerService;
import com.TYR.MainPackage.Service.EnumClassifier;
import com.TYR.MainPackage.Service.MemberShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import jakarta.persistence.criteria.Predicate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberShopImplementator implements MemberShopService {
    private final MemberShop memberShop;
    private final CustomerService customerService;
    private final EnumClassifier enumClassifier;

    @Override
    public NewEntryResponse<MembershipShop> newItem(ShopDTO shopDTO) {
        MembershipShop membershipShop = MembershipShop.builder()
                .type(enumClassifier.getItemType(shopDTO.getItemType()))
                .price(shopDTO.getPrice())
                .description(shopDTO.getDescription())
                .stock(shopDTO.getStock())
                .tier(enumClassifier.getMemberTier(shopDTO.getMemberTier()))
                .build();

        return NewEntryResponse.<MembershipShop>builder()
                .data(memberShop.save(membershipShop))
                .build();
    }

    @Override
    public List<MembershipShop> getAllItem(String userId) {
        Customer customer = customerService.getCustomerData(userId);

        return memberShop.findBytierLessThanEqual(customer.getTier());
    }
}
