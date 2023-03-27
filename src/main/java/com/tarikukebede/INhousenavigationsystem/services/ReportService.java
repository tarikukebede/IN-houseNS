package com.tarikukebede.INhousenavigationsystem.services;

import com.tarikukebede.INhousenavigationsystem.dtos.ReportInDto;
import com.tarikukebede.INhousenavigationsystem.entities.BaseStation;
import com.tarikukebede.INhousenavigationsystem.entities.Detection;
import com.tarikukebede.INhousenavigationsystem.entities.Report;
import com.tarikukebede.INhousenavigationsystem.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReportService extends ServiceTemplate<Report, UUID> {

    private final BaseStationService baseStationService;
    private final DetectionService detectionService;

    @Autowired
    public ReportService(
            ReportRepository repository,
            BaseStationService baseStationService,
            DetectionService detectionService){
        super(repository, new Report());
        this.baseStationService = baseStationService;
        this.detectionService = detectionService;
    }

    public Report createReport(ReportInDto request){
        BaseStation baseStation = baseStationService.get(request.getBase_station_id());
        List<Detection> reports = detectionService.createAll(request.getReports());
        return super.create(new Report(baseStation, reports));
    }
}
