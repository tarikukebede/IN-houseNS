package com.tarikukebede.INhousenavigationsystem.Services;

import com.tarikukebede.INhousenavigationsystem.dtos.DetectionInDto;
import com.tarikukebede.INhousenavigationsystem.dtos.ReportInDto;
import com.tarikukebede.INhousenavigationsystem.entities.BaseStation;
import com.tarikukebede.INhousenavigationsystem.entities.Detection;
import com.tarikukebede.INhousenavigationsystem.entities.Report;
import com.tarikukebede.INhousenavigationsystem.repositories.ReportRepository;
import com.tarikukebede.INhousenavigationsystem.services.BaseStationService;
import com.tarikukebede.INhousenavigationsystem.services.DetectionService;
import com.tarikukebede.INhousenavigationsystem.services.ReportService;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class ReportServiceTest {

    @InjectMocks
    private ReportService underTest;

    @Mock
    private ReportRepository repository;

    @Mock
    private BaseStationService baseStationService;

    @Mock
    private DetectionService detectionService;


    @Test
    void testCreate(){
        ReportInDto inDto = new ReportInDto();
        inDto.setBase_station_id(UUID.randomUUID());
        inDto.setReports(new ArrayList<>());

        Report report = new Report();
        report.setId(UUID.randomUUID());
        report.setDetections(new ArrayList<>());
        report.setBaseStation(new BaseStation());

        when(repository.save(any(Report.class))).thenReturn(report);
        when(baseStationService.get(any(UUID.class))).thenReturn(new BaseStation());
        when(detectionService.createAll(any(List.class))).thenReturn(new ArrayList<Detection>());

        Report result = underTest.createReport(inDto);
        assertThat(result).isEqualTo(report);
    }
}
