package com.TYR.MainPackage.Service.Implementator;

import com.TYR.MainPackage.Model.DataTransferObject.NewRequest;
import com.TYR.MainPackage.Model.DataTransferObject.NewTracker;
import com.TYR.MainPackage.Service.EnumClassifier;
import com.TYR.MainPackage.Strings.Enums.*;
import org.springframework.stereotype.Service;

@Service
public class EnumClassifierImplementator implements EnumClassifier {
    @Override
    public MissionType getMissionType(int num) {
        return switch (num) {
            case 0 -> MissionType.SPEND_POINTS;
            case 1 -> MissionType.TOTAL_TRANSACTION;
            case 2 -> MissionType.TOTAL_MONEY_SPEND;
            default -> throw new IllegalArgumentException();
        };
    }

    @Override
    public MembershipTier getMemberTier(int num) {
        return switch (num) {
            case 0 -> MembershipTier.BRONZE;
            case 1 -> MembershipTier.SILVER;
            case 2 -> MembershipTier.GOLD;
            case 3 -> MembershipTier.PLATINUM;
            case 4 -> MembershipTier.DIAMOND;
            default -> throw new IllegalArgumentException();
        };
    }

    @Override
    public OfferType getOfferType(int num) {
        return switch (num) {
            case 0 -> OfferType.OFFER_CASHBACK;
            case 1 -> OfferType.OFFER_DISCOUNT;
            case 2 -> OfferType.OFFER_FREE_DELIVERY;
            case 3 -> OfferType.OFFER_COMBO;
            case 4 -> OfferType.OFFER_BONUS_POINTS;
            case 5 -> OfferType.OFFER_REFERRAL_EVENT;
            case 6 -> OfferType.OFFER_LOTTERY;
            case 7 -> OfferType.OFFER_GIVEAWAY;
            default -> throw new IllegalArgumentException();
        };
    }

    @Override
    public ResetType getResetType(int num) {
        return switch (num) {
            case 0 -> ResetType.RESET_DAILY;
            case 1 -> ResetType.RESET_WEEKLY;
            case 2 -> ResetType.RESET_MONTHLY;
            case 3 -> ResetType.RESET_YEARLY;
            case 4 -> ResetType.PERMANENT;
            default -> throw new IllegalArgumentException();
        };
    }

    @Override
    public ItemType getItemType(int num) {
        return switch (num) {
            case 0 -> ItemType.DISCOUNT_VOUCHER;
            case 1 -> ItemType.PHYSICAL_ITEM;
            case 2 -> ItemType.DIGITAL_VOUCHER;
            default -> throw new IllegalArgumentException();
        };
    }
}
