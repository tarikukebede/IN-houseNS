package com.tarikukebede.INhousenavigationsystem.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PointDistance {
    private double[] distances;
    private double[][] points;
}
