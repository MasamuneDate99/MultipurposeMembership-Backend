package com.TYR.MainPackage.Model.DataTransferObject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewTracker {
    private Date startDate;
    private Date endDate;
    private Time endTime;
    private Long progress;
    private Long target;
    private Boolean isCleared = Boolean.FALSE;
    private Boolean rewardSent = Boolean.FALSE;
    private Boolean manualCheck = Boolean.FALSE;
    private int resetType;
}
