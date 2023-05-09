package com.tarikukebede.INhousenavigationsystem.utils;

import com.tarikukebede.INhousenavigationsystem.entities.BaseStation;
import com.tarikukebede.INhousenavigationsystem.entities.Detection;
import com.tarikukebede.INhousenavigationsystem.entities.MobileStation;
import com.tarikukebede.INhousenavigationsystem.entities.Report;
import com.tarikukebede.INhousenavigationsystem.services.BaseStationService;
import com.tarikukebede.INhousenavigationsystem.services.MobileStationService;
import com.tarikukebede.INhousenavigationsystem.services.ReportService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class Seeder implements CommandLineRunner {

    private final BaseStationService baseStationService;
    private final MobileStationService mobileStationService;
    private final ReportService reportService;

    public Seeder(BaseStationService baseStationService, MobileStationService mobileStationService, ReportService reportService) {
        this.baseStationService = baseStationService;
        this.mobileStationService = mobileStationService;
        this.reportService = reportService;
    }

    @Override
    public void run(String... args) {

        BaseStation bs1 = new BaseStation();
        bs1.setName("BS1");
        bs1.setX(0);
        bs1.setY(0);
        bs1.setDetectionRadiusInMeters(20);

        bs1 = baseStationService.create(bs1);

        BaseStation bs2 = new BaseStation();
        bs2.setName("BS2");
        bs2.setX(0);
        bs2.setY(5);
        bs2.setDetectionRadiusInMeters(20);

        bs2 = baseStationService.create(bs2);

        BaseStation bs3 = new BaseStation();
        bs3.setName("BS3");
        bs3.setX(5);
        bs3.setY(0);
        bs3.setDetectionRadiusInMeters(20);

        bs3 = baseStationService.create(bs3);

        MobileStation ms = new MobileStation();
        ms.setLastKnownX(2.5f);
        ms.setLastKnownY(2.5f);
        ms = mobileStationService.create(ms);

        Report rt1 = new Report();
        Report rt2 = new Report();
        Report rt3 = new Report();

        Detection dt1 = new Detection();
        Detection dt2 = new Detection();
        Detection dt3 = new Detection();
        Detection dt4 = new Detection();
        Detection dt5 = new Detection();

        dt1.setTimeStamp(new Date());
        dt1.setReport(rt1);
        dt1.setDistance(2.5f);
        dt1.setMobileStation(ms);

        dt2.setTimeStamp(new Date());
        dt2.setReport(rt2);
        dt2.setDistance(2.5f);
        dt2.setMobileStation(ms);

        dt3.setTimeStamp(new Date());
        dt3.setReport(rt3);
        dt3.setDistance(2.5f);
        dt3.setMobileStation(ms);

        dt4.setTimeStamp(Helper.addMinutesToDate(new Date(), 30));
        dt4.setReport(rt3);
        dt4.setDistance(1.5f);
        dt4.setMobileStation(ms);

        dt5.setTimeStamp(Helper.addMinutesToDate(new Date(), 60));
        dt5.setReport(rt3);
        dt5.setDistance(1f);
        dt5.setMobileStation(ms);

        List<Detection> dtList1 = new ArrayList<>();
        dtList1.add(dt1);

        List<Detection> dtList2 = new ArrayList<>();
        dtList2.add(dt2);

        List<Detection> dtList3 = new ArrayList<>();
        dtList3.add(dt3);
        dtList3.add(dt4);
        dtList3.add(dt5);

        rt1.setBaseStation(bs1);
        rt1.setDetections(dtList1);

        rt2.setBaseStation(bs2);
        rt2.setDetections(dtList2);

        rt3.setBaseStation(bs3);
        rt3.setDetections(dtList3);

        reportService.create(rt1);
        reportService.create(rt2);
        reportService.create(rt3);

    }
}