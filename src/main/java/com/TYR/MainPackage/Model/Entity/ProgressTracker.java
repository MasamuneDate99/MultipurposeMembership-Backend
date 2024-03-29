package com.TYR.MainPackage.Model.Entity;

import com.TYR.MainPackage.Strings.Enums.ResetType;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "progress_tracker")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProgressTracker {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Date startDate;
    private Date endDate;
    private Time endTime;
    private Long progress;
    private Long target;
    private Boolean isCleared = Boolean.FALSE;
    private Boolean rewardSent = Boolean.FALSE;
    private Boolean manualCheck = Boolean.FALSE;
    private ResetType reset;
}
