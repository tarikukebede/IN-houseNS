package com.tarikukebede.INhousenavigationsystem.services;

import com.tarikukebede.INhousenavigationsystem.dtos.LocationOutDto;
import com.tarikukebede.INhousenavigationsystem.dtos.PointDistance;
import com.tarikukebede.INhousenavigationsystem.dtos.TrilaterationResult;
import com.tarikukebede.INhousenavigationsystem.entities.Detection;
import com.tarikukebede.INhousenavigationsystem.exception.ErrorHandler;
import com.tarikukebede.INhousenavigationsystem.utils.Helper;
import com.tarikukebede.INhousenavigationsystem.utils.Transform;
import com.tarikukebede.INhousenavigationsystem.utils.Trilateration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author Tariku Kebede
 * In a real life case, this service will be responsible
 * for retriving the latest location of the mobile station
 * based on the reports recorded by base stations
 **/
@Service
public class LocationService extends ErrorHandler<Detection, UUID> {
    private final MobileStationService mobileStationService;
    private final DetectionService detectionService;

    public LocationService(
            MobileStationService mobileStationService,
            DetectionService detectionService) {
        super(new Detection());
        this.mobileStationService = mobileStationService;
        this.detectionService = detectionService;
    }

    public LocationOutDto get(UUID mobileStationId) {
        return Transform.toLocationOut(mobileStationService.get(mobileStationId));
    }

    public LocationOutDto getMobileStationLocation(UUID mobileStationId) {
        List<Detection> detections = detectionService.findDetectionsByMobileStationId(mobileStationId);
        if (detections.size() < 2) {
            LocationOutDto response = new LocationOutDto();
            response.setMobileId(mobileStationId);
            response.setErrorCode(400);
            response.setErrorDescription("Not enough information available to determine location");
            return response;
        }
        TrilaterationResult result = calculateLocation(detections.subList(0, 3));
        return Transform.toLocationOut(result, mobileStationId);
    }

    private TrilaterationResult calculateLocation(List<Detection> detections) {
        PointDistance pointDistances = Helper.getPointDistances(detections);
        return Trilateration.calculate(pointDistances.getDistances(), pointDistances.getPoints());
    }
}
