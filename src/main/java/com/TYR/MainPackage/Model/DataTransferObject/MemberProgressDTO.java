package com.TYR.MainPackage.Model.DataTransferObject;

import com.TYR.MainPackage.Strings.Enums.ResetType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberProgressDTO {
    private Date startDate;
    private Date endDate;
    private Time endTime;
    private Long progress;
    private Long target;
    private Boolean isCleared = Boolean.FALSE;
    private Boolean rewardSent = Boolean.FALSE;
}