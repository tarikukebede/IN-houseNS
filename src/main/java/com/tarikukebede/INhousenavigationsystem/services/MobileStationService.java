package com.tarikukebede.INhousenavigationsystem.services;

import com.tarikukebede.INhousenavigationsystem.dtos.MobileStationInDto;
import com.tarikukebede.INhousenavigationsystem.entities.MobileStation;
import com.tarikukebede.INhousenavigationsystem.repositories.MobileStationRepository;
import com.tarikukebede.INhousenavigationsystem.utils.Transform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MobileStationService extends ServiceTemplate<MobileStation, UUID> {
    @Autowired
    public MobileStationService(MobileStationRepository repository) {
        super(repository, new MobileStation());
    }

    public UUID create(MobileStationInDto request){
        return super.create(Transform.toMobileStation(request)).getId();
    }

}
