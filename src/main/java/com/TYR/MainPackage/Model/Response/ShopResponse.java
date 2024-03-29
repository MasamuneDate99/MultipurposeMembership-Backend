//package com.TYR.MainPackage.Model.Response;
//
//import com.TYR.MainPackage.Model.DataTransferObject.ShopDTO;
//import com.TYR.MainPackage.Model.Entity.MembershipShop;
//import com.TYR.MainPackage.Service.MemberShopService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.jpa.domain.Specification;
//import jakarta.persistence.criteria.*;
//
//import java.util.ArrayList;
//
//@RequiredArgsConstructor
//public class ShopResponse {
//    private final MemberShopService shopService;
//    public Specification<MembershipShop> getSpecification(ShopDTO shopDTO){
//        return (root, query, criteriaBuilder) -> {
//            ArrayList<Predicate> predicates = new ArrayList<>();
//            predicates.add(shopService.get());
//        };
//    }
//}