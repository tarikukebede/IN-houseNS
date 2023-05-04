package com.tarikukebede.INhousenavigationsystem.services;

import com.tarikukebede.INhousenavigationsystem.dtos.DetectionInDto;
import com.tarikukebede.INhousenavigationsystem.entities.Detection;
import com.tarikukebede.INhousenavigationsystem.entities.MobileStation;
import com.tarikukebede.INhousenavigationsystem.repositories.DetectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DetectionService extends ServiceTemplate<Detection, UUID> {

    private final MobileStationService mobileStationService;

    @Autowired
    public DetectionService(DetectionRepository repository, MobileStationService mobileStationService){
        super(repository, new Detection());
        this.mobileStationService = mobileStationService;
    }

    public Detection create(DetectionInDto request){
        MobileStation mobileStation = mobileStationService.get(request.getMobile_station_id());
        return super.create(new Detection(request.getDistance().floatValue(), request.getTimeStamp(), mobileStation, null));
    }

    public List<Detection> createAll(List<DetectionInDto> detectionInDtos){
        return detectionInDtos.stream().map(this::create).collect(Collectors.toList());
    }
}
