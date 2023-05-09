package com.tarikukebede.INhousenavigationsystem.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MobileStation extends Model{
    @NotNull(message = "lastKnownX is required")
    private float lastKnownX;
    @NotNull(message = "lastKnownY is required")
    private float lastKnownY;
    @OneToMany(mappedBy = "mobileStation", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Collection<Detection> detections = new ArrayList<>();
}
