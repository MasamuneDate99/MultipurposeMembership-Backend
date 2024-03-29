package com.TYR.MainPackage.Repository;

import com.TYR.MainPackage.Model.Entity.MembershipOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberOfferRepository extends JpaRepository<MembershipOffer, String> {
}
