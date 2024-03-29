package com.TYR.MainPackage.Service.Implementator;

import com.TYR.MainPackage.Model.DataTransferObject.BenefitDTO;
import com.TYR.MainPackage.Model.DataTransferObject.MemberProgressDTO;
import com.TYR.MainPackage.Model.DataTransferObject.NewRequest;
import com.TYR.MainPackage.Model.Entity.BenefitProgram;
import com.TYR.MainPackage.Model.Entity.ProgressTracker;
import com.TYR.MainPackage.Repository.BenefitRepository;
import com.TYR.MainPackage.Service.BenefitService;
import com.TYR.MainPackage.Service.EnumClassifier;
import com.TYR.MainPackage.Service.ProgressTrackerService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BenefitServiceImplementator implements BenefitService {
    private final BenefitRepository benefitRepository;
    private final ProgressTrackerService trackerService;
    private final EnumClassifier enumClassifier;
    @Override
    public BenefitDTO<MemberProgressDTO> getBenefitDetail(String name) {
        BenefitProgram benefitProgram = benefitRepository.findByname(name);
        MemberProgressDTO response = trackerService.getMemberTracker(benefitProgram.getProgressTracker().getId());
        return BenefitDTO.<MemberProgressDTO>builder()
                .id(benefitProgram.getId())
                .name(benefitProgram.getName())
                .description(benefitProgram.getDescription())
                .shortDescription(benefitProgram.getShortDescription())
                .tier(benefitProgram.getTier())
                .progressData(response)
                .build();
    }

    @Override
    public BenefitProgram createNewBenefit(NewRequest newRequest) {
        BenefitProgram benefitProgram = BenefitProgram.builder()
                .name(newRequest.getName())
                .description(newRequest.getDescription())
                .shortDescription(newRequest.getShortDescription())
                .tier(enumClassifier.getMemberTier(newRequest.getMemberTier()))
                .build();
        benefitRepository.save(benefitProgram);

        ProgressTracker progressTracker = ProgressTracker.builder()
                .startDate(newRequest.getStartDate())
                .endDate(newRequest.getEndDate())
                .endTime(newRequest.getEndTime())
                .progress(newRequest.getProgress())
                .target(newRequest.getTarget())
                .isCleared(false)
                .rewardSent(false)
                .manualCheck(false)
                .build();
        trackerService.createNewTracker(progressTracker);

        return benefitRepository.findById(benefitProgram.getId()).get();
    }

    @Override
    public BenefitDTO updateBenefit(NewRequest newRequest) {
        BenefitProgram benefitProgram = benefitRepository.findByname(newRequest.getName());
        if(benefitProgram != null){
            benefitProgram = BenefitProgram.builder()
                    .name(newRequest.getName())
                    .description(newRequest.getDescription())
                    .shortDescription(newRequest.getShortDescription())
                    .tier(enumClassifier.getMemberTier(newRequest.getMemberTier()))
                    .build();
        }
        else throw new DataRetrievalFailureException("Benefit not found !");

        return BenefitDTO.builder()
                .name(benefitProgram.getName())
                .description(benefitProgram.getDescription())
                .shortDescription(benefitProgram.getShortDescription())
                .tier(benefitProgram.getTier())
                .build();
    }

    @Override
    public void deleteBenefit(String id) {
        if(benefitRepository.existsById(id)){
            benefitRepository.deleteById(id);
        } else throw new DataRetrievalFailureException("Benefit not found !");
    }
}
