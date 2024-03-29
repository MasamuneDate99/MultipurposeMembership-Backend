package com.TYR.MainPackage.Repository;

import com.TYR.MainPackage.Model.Entity.ProgressTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgressTrackerRepository extends JpaRepository<ProgressTracker, String> {
}
