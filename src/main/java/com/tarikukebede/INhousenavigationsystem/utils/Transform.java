package com.tarikukebede.INhousenavigationsystem.utils;

import com.tarikukebede.INhousenavigationsystem.dtos.LocationOutDto;
import com.tarikukebede.INhousenavigationsystem.dtos.MobileStationInDto;
import com.tarikukebede.INhousenavigationsystem.dtos.TrilaterationResult;
import com.tarikukebede.INhousenavigationsystem.entities.Detection;
import com.tarikukebede.INhousenavigationsystem.entities.MobileStation;

import java.util.ArrayList;
import java.util.UUID;

public class Transform {

    public static MobileStation toMobileStation(MobileStationInDto mobileStationInDto) {
        return MobileStation.builder()
                .lastKnownX(mobileStationInDto.getLastKnownX().floatValue())
                .lastKnownY(mobileStationInDto.getLastKnownY().floatValue())
                .detections(new ArrayList<>())
                .build();
    }

    public static LocationOutDto toLocationOut(MobileStation mobileStation) {
        return LocationOutDto.builder()
                .mobileId(mobileStation.getId())
                .x(mobileStation.getLastKnownX())
                .y(mobileStation.getLastKnownY())
                .build();
    }

    public static double[] toBaseStationCoordinates(Detection detection) {
        return new double[]{detection.getReport().getBaseStation().getX(), detection.getReport().getBaseStation().getY()};
    }

    public static LocationOutDto toLocationOut(
            TrilaterationResult trilaterationResult,
            UUID mobileStationId) {
        return LocationOutDto.builder()
                .mobileId(mobileStationId)
                .x(trilaterationResult.getX())
                .y(trilaterationResult.getY())
                .errorRadius(trilaterationResult.getErrorRadius())
                .build();
    }

}
