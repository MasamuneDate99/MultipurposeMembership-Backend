package com.TYR.MainPackage.Model.Entity;

import com.TYR.MainPackage.Strings.Enums.MissionType;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "mission_list")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MembershipMission {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String shortDescription;
    private String description;
    private String rewardInfo;
    private MissionType missionType;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "progressTracker_id")
    private ProgressTracker progressTracker;
}