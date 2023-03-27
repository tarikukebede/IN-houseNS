package com.tarikukebede.INhousenavigationsystem.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseStation extends Model {
   @NotEmpty(message = "Name is required")
   private String name;
   @NotNull(message = "X is required")
   private float x;

   @NotNull(message = "Y is required")
   private float y;
   @NotNull(message = "Detection radius is a required")
   private float detectionRadiusInMeters;
}
