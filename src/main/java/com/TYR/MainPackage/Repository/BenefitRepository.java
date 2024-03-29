package com.TYR.MainPackage.Repository;

import com.TYR.MainPackage.Model.Entity.BenefitProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenefitRepository extends JpaRepository<BenefitProgram, String> {
    BenefitProgram findByname(String name);
}
