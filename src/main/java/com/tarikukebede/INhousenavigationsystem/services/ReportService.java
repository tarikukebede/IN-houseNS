package com.tarikukebede.INhousenavigationsystem.services;

import com.tarikukebede.INhousenavigationsystem.dtos.ReportInDto;
import com.tarikukebede.INhousenavigationsystem.entities.BaseStation;
import com.tarikukebede.INhousenavigationsystem.entities.Detection;
import com.tarikukebede.INhousenavigationsystem.entities.MobileStation;
import com.tarikukebede.INhousenavigationsystem.entities.Report;
import com.tarikukebede.INhousenavigationsystem.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ReportService extends ServiceTemplate<Report, UUID> {

    private final BaseStationService baseStationService;

    private final MobileStationService mobileStationService;

    @Autowired
    public ReportService(
            ReportRepository repository,
            BaseStationService baseStationService,
            MobileStationService mobileStationService) {
        super(repository, new Report());
        this.baseStationService = baseStationService;
        this.mobileStationService = mobileStationService;
    }

    public Report createReport(ReportInDto request) {
        BaseStation baseStation = baseStationService.get(request.getBase_station_id());
        Report report = new Report();
        List<Detection> detections = request.getDetections().stream().map(detectionInDto -> {
            Detection detection = new Detection();
            MobileStation mobileStation = mobileStationService.get(detectionInDto.getMobileStationId());
            detection.setReport(report);
            detection.setDistance(detectionInDto.getDistance().floatValue());
            detection.setMobileStation(mobileStation);
            detection.setTimeStamp(detectionInDto.getTimeStamp());
            return detection;
        }).collect(Collectors.toList());
        report.setDetections(detections);
        report.setBaseStation(baseStation);
        return super.create(report);
    }

}
