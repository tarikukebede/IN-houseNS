package com.tarikukebede.INhousenavigationsystem.dtos;

import com.tarikukebede.INhousenavigationsystem.validations.ValidUUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportInDto {

  @ValidUUID
  private UUID base_station_id;

  @Valid
  private ArrayList<DetectionInDto> reports;

}
