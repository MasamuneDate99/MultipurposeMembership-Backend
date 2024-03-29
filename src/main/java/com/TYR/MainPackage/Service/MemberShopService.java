package com.TYR.MainPackage.Service;

import com.TYR.MainPackage.Model.DataTransferObject.NewRequest;
import com.TYR.MainPackage.Model.DataTransferObject.ShopDTO;
import com.TYR.MainPackage.Model.Entity.MembershipShop;

import com.TYR.MainPackage.Model.Response.NewEntryResponse;

import java.util.List;

public interface MemberShopService {
    NewEntryResponse<MembershipShop> newItem(ShopDTO shopDTO);
    List<MembershipShop> getAllItem(String userId);
}