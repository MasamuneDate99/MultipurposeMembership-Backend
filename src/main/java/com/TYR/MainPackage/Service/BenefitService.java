package com.TYR.MainPackage.Service;

import com.TYR.MainPackage.Model.DataTransferObject.BenefitDTO;
import com.TYR.MainPackage.Model.DataTransferObject.MemberProgressDTO;
import com.TYR.MainPackage.Model.DataTransferObject.NewRequest;
import com.TYR.MainPackage.Model.Entity.BenefitProgram;

public interface BenefitService {
    BenefitDTO<MemberProgressDTO> getBenefitDetail(String name);
    BenefitProgram createNewBenefit(NewRequest newRequest);
    BenefitDTO updateBenefit(NewRequest newRequest);
    void deleteBenefit(String id);
}