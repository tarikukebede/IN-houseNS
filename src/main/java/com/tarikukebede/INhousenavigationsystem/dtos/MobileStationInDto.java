package com.tarikukebede.INhousenavigationsystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MobileStationInDto {
    @NotNull
    private float lastKnownX;

    @NotNull
    private float lastKnownY;
}
