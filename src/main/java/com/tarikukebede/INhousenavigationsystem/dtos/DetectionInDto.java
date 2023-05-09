package com.tarikukebede.INhousenavigationsystem.dtos;

import com.tarikukebede.INhousenavigationsystem.validations.ValidUUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetectionInDto {
    @ValidUUID
    private UUID mobileStationId;

    @NotNull(message = "distance can not be null")
    @DecimalMin(value = "0", message = "distance can not be negative")
    private BigDecimal distance;
    @NotNull
    private Date timeStamp;
}
