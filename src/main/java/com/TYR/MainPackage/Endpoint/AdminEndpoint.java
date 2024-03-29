package com.TYR.MainPackage.Endpoint;

import com.TYR.MainPackage.Model.DataTransferObject.NewRequest;
import com.TYR.MainPackage.Model.DataTransferObject.ShopDTO;
import com.TYR.MainPackage.Model.Entity.BenefitProgram;
import com.TYR.MainPackage.Model.Entity.MembershipShop;
import com.TYR.MainPackage.Model.Response.GeneralResponse;
import com.TYR.MainPackage.Model.Response.NewEntryResponse;
import com.TYR.MainPackage.Service.*;
import com.TYR.MainPackage.Strings.EndpointPath;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(EndpointPath.ADMIN)
public class AdminEndpoint {
    private final MissionService missionService;
    private final BenefitService benefitService;
    private final MemberShopService shopService;
    private final EventService eventService;
    private final OfferService offerService;

    GeneralResponse<NewEntryResponse> shopResponse;

    @PostMapping(EndpointPath.BENEFIT)
    public ResponseEntity<?> createBenefitProgram(@RequestBody NewRequest newRequest){
        GeneralResponse<BenefitProgram> response = GeneralResponse.<BenefitProgram>builder()
                .status(HttpStatus.CREATED.value())
                .message("Successfully created new Benefit")
                .data(benefitService.createNewBenefit(newRequest))
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public ResponseEntity<?> getBenefitProgram(){
        return null;
    }

    public ResponseEntity<?> updateBenefitProgram(){
        return null;
    }

    public ResponseEntity<?> deleteBenefitProgram(){
        return null;
    }

    public ResponseEntity<?> createMission(){
        return null;
    }

    public ResponseEntity<?> getMission(){
        return null;
    }

    public ResponseEntity<?> updateMission(){
        return null;
    }

    public ResponseEntity<?> deleteMission(){
        return null;
    }

    public ResponseEntity<?> createEvent(){
        return null;
    }

    public ResponseEntity<?> getEvent(){
        return null;
    }

    public ResponseEntity<?> updateEvent(){
        return null;
    }

    public ResponseEntity<?> deleteEvent(){
        return null;
    }

    public ResponseEntity<?> createMemberOffer(){
        return null;
    }

    public ResponseEntity<?> getMemberOffer(){
        return null;
    }

    public ResponseEntity<?> updateMemberOffer(){
        return null;
    }

    public ResponseEntity<?> deleteMemberOffer(){
        return null;
    }

    @PostMapping(EndpointPath.SHOP)
    public ResponseEntity<?> addNewMemberShopItem(@RequestBody ShopDTO shopDTO){
        NewEntryResponse<MembershipShop> newShopItem = shopService.newItem(shopDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(newShopItem);
    }

    public ResponseEntity<?> getAllMemberShopItem(){
        return null;
    }

    public ResponseEntity<?> updateMemberShopItem(){
        return null;
    }

    public ResponseEntity<?> deleteMemberShopItem(){
        return null;
    }
}
