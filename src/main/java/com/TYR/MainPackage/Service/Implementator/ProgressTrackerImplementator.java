package com.TYR.MainPackage.Service.Implementator;

import com.TYR.MainPackage.Model.DataTransferObject.MemberProgressDTO;
import com.TYR.MainPackage.Model.Entity.ProgressTracker;
import com.TYR.MainPackage.Repository.ProgressTrackerRepository;
import com.TYR.MainPackage.Service.BenefitService;
import com.TYR.MainPackage.Service.ProgressTrackerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProgressTrackerImplementator implements ProgressTrackerService {
    private final ProgressTrackerRepository progressTrackerRepository;
    private final BenefitService benefitService;
    @Override
    public MemberProgressDTO getMemberTracker(String id) {
        ProgressTracker progressTracker = progressTrackerRepository.findById(id).get();

        return MemberProgressDTO.builder()
                .startDate(progressTracker.getStartDate())
                .endDate(progressTracker.getEndDate())
                .endTime(progressTracker.getEndTime())
                .progress(progressTracker.getProgress())
                .target(progressTracker.getTarget())
                .isCleared(progressTracker.getIsCleared())
                .rewardSent(progressTracker.getRewardSent())
                .build();
    }

    @Override
    public ProgressTracker getTrackerForAdmin(String id) {
        return progressTrackerRepository.findById(id).get();
    }

    @Override
    public void createNewTracker(ProgressTracker progressTracker) {
        progressTrackerRepository.save(progressTracker);
    }
}