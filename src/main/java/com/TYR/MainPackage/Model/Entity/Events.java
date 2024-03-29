package com.TYR.MainPackage.Model.Entity;

import com.TYR.MainPackage.Strings.Enums.MembershipTier;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "events")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String description;
    private String shortDescription;
    private MembershipTier tier;

    @OneToOne
    @JoinColumn(name = "progressTracker_id")
    private ProgressTracker progressTracker;
}