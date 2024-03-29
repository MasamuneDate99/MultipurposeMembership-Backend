package com.TYR.MainPackage.Service;

import com.TYR.MainPackage.Model.DataTransferObject.NewRequest;
import com.TYR.MainPackage.Model.DataTransferObject.NewTracker;
import com.TYR.MainPackage.Strings.Enums.*;

public interface EnumClassifier {
    MissionType getMissionType(int num);
    MembershipTier getMemberTier(int num);
    OfferType getOfferType(int num);
    ResetType getResetType(int num);
    ItemType getItemType(int num);
}