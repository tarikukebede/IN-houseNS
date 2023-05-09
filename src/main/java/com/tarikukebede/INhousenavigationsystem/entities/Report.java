package com.tarikukebede.INhousenavigationsystem.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report extends Model{
   @ManyToOne
   private BaseStation baseStation;
   @OneToMany(mappedBy = "report", cascade = CascadeType.ALL)
   @JsonManagedReference
   private Collection<Detection> detections = new ArrayList<>();
}
