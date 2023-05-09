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
    private float errorRadius;
    private int errorCode;
    private String errorDescription;
}
