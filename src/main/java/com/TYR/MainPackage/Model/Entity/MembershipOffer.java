package com.TYR.MainPackage.Model.Entity;

import com.TYR.MainPackage.Strings.Enums.MembershipTier;
import com.TYR.MainPackage.Strings.Enums.OfferType;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "member_offer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MembershipOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private OfferType type;
    private String shortDescription;
    private String description;
    private MembershipTier membershipTier;

    @OneToOne
    @JoinColumn(name = "progressTracker_id")
    private ProgressTracker progressTracker;
}