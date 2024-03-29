package com.TYR.MainPackage.Model.DataTransferObject;

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
public class NewRequest {
    private String name;
    private String description;
    private String shortDescription;
    private String rewardInfo;
    private int price;
    private int stock;
    private int missionType;
    private int memberTier;
    private int offerType;
    private int itemType;

    // For tracker purpose only
    private Date startDate;
    private Date endDate;
    private Time endTime;
    private Long progress;
    private Long target;
    private int resetType;
    private Boolean isCleared;
    private Boolean rewardSent;
    private Boolean manualCheck;
}
