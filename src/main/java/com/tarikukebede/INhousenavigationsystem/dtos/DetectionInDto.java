package com.tarikukebede.INhousenavigationsystem.dtos;

import com.tarikukebede.INhousenavigationsystem.validations.ValidUUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetectionInDto {
    private UUID mobile_station_id;

    private float distance;
    private Date timeStamp;
}
