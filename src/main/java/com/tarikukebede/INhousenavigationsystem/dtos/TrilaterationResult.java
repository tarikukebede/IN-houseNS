package com.tarikukebede.INhousenavigationsystem.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TrilaterationResult {
    private float x;
    private float y;
    private float errorRadius;
}
