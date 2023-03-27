package com.tarikukebede.INhousenavigationsystem.utils;

import com.tarikukebede.INhousenavigationsystem.dtos.LocationOutDto;
import com.tarikukebede.INhousenavigationsystem.dtos.MobileStationInDto;
import com.tarikukebede.INhousenavigationsystem.entities.MobileStation;

import java.util.ArrayList;

public class Transform {

    public static MobileStation toMobileStation(MobileStationInDto mobileStationInDto){
        return MobileStation.builder()
                .lastKnownX(mobileStationInDto.getLastKnownX())
                .lastKnownY(mobileStationInDto.getLastKnownY())
                .detections(new ArrayList<>())
                .build();
    }

    public static LocationOutDto toLocationOut(MobileStation mobileStation){
        return LocationOutDto.builder()
                .mobileId(mobileStation.getId())
                .x(mobileStation.getLastKnownX())
                .y(mobileStation.getLastKnownY())
                .build();
    }
}
