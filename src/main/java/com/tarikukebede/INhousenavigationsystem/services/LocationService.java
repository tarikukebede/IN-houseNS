package com.tarikukebede.INhousenavigationsystem.services;

import com.tarikukebede.INhousenavigationsystem.dtos.LocationOutDto;
import com.tarikukebede.INhousenavigationsystem.utils.Transform;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Tariku Kebede
 * In a real life case, this service will be responsible
 * for retriving the latest location of the mobile station
 * based on the reports recorded by base stations
 **/
@Service
@RequiredArgsConstructor
public class LocationService {
    private final MobileStationService mobileStationService;

    public LocationOutDto get(UUID mobileStationId){
        return Transform.toLocationOut(mobileStationService.get(mobileStationId));
    }
}
