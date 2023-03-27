package com.tarikukebede.INhousenavigationsystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocationOutDto {
    private UUID mobileId;
    private float x;
    private float y;
    private float error_radius;
    private int error_code;
    private String error_description;
}
