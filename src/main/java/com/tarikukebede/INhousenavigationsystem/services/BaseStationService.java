package com.tarikukebede.INhousenavigationsystem.services;

import com.tarikukebede.INhousenavigationsystem.entities.BaseStation;
import com.tarikukebede.INhousenavigationsystem.repositories.BaseStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class BaseStationService extends ServiceTemplate<BaseStation, UUID> {

    @Autowired
    public BaseStationService(BaseStationRepository repository) {
        super(repository, new BaseStation());
    }
}
