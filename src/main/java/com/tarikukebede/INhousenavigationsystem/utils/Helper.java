package com.tarikukebede.INhousenavigationsystem.utils;

import com.tarikukebede.INhousenavigationsystem.dtos.PointDistance;
import com.tarikukebede.INhousenavigationsystem.entities.Detection;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Helper {

    public static Date addMinutesToDate(Date date, int minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minutes);
        return calendar.getTime();
    }

    public static PointDistance getPointDistances(List<Detection> detections) {
        double[][] positions = new double[detections.size()][2];
        double[] distances = new double[detections.size()];
        for (int i = 0; i < detections.size(); i++) {
            positions[i] = Transform.toBaseStationCoordinates(detections.get(i));
            distances[i] = detections.get(i).getDistance();
        }
        return PointDistance.builder()
                .points(positions)
                .distances(distances)
                .build();
    }
}
