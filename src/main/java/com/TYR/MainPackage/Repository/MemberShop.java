package com.TYR.MainPackage.Repository;

import com.TYR.MainPackage.Model.DataTransferObject.ShopDTO;
import com.TYR.MainPackage.Model.Entity.MembershipShop;
import com.TYR.MainPackage.Strings.Enums.MembershipTier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberShop extends JpaRepository<MembershipShop, String> {
//    Page<MembershipShop> findAll(Pageable pageable, ShopDTO shopDTO);
    List<MembershipShop> findBytierLessThanEqual(MembershipTier membershipTier);
}