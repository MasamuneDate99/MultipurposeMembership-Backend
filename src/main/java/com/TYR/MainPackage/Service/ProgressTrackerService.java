package com.TYR.MainPackage.Service;

import com.TYR.MainPackage.Model.DataTransferObject.MemberProgressDTO;
import com.TYR.MainPackage.Model.Entity.ProgressTracker;

public interface ProgressTrackerService {
    MemberProgressDTO getMemberTracker(String id);
    ProgressTracker getTrackerForAdmin(String id);
    void createNewTracker(ProgressTracker progressTracker);
}
