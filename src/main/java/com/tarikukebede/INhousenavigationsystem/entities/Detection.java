package com.tarikukebede.INhousenavigationsystem.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Detection extends Model {
    @NotNull(message = "Distance can not be null")
    private float distance;

    @NotNull(message = "Timestamp can not be null")
    private Date timeStamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mobileStation_id")
    @JsonBackReference
    private MobileStation mobileStation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "report_id")
    @JsonBackReference
    private Report report;

}
