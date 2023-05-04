package com.tarikukebede.INhousenavigationsystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MobileStationInDto {
    @NotNull(message = "lastKnowX can not be null")
    @Digits(integer = 3, fraction = 3, message = "lastKnowX should have 0000.000 format")
    @DecimalMax(value = "999999", message = "invalid lastKnownX, max value 999999")
    @DecimalMin(value = "-999999", message = "invalid lastKnownX, min value -999999")
    private BigDecimal lastKnownX;

    @NotNull(message = "lastKnowY can not be null")
    @Digits(integer = 3, fraction = 3, message = "lastKnowY should have 0000.000 format")
    @DecimalMax(value = "999999", message = "invalid lastKnownY, max value 999999")
    @DecimalMin(value = "-999999", message = "invalid lastKnownY, min value -999999")
    private BigDecimal lastKnownY;
}
