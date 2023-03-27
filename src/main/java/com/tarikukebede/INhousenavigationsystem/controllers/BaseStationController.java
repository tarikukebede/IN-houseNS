package com.tarikukebede.INhousenavigationsystem.controllers;

import com.tarikukebede.INhousenavigationsystem.entities.BaseStation;
import com.tarikukebede.INhousenavigationsystem.services.BaseStationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Base Station")
@RestController
@RequestMapping("/base_stations")
@RequiredArgsConstructor
public class BaseStationController {

    private final BaseStationService baseStationService;

    @PostMapping
    public BaseStation create(@RequestBody  BaseStation request){
        return baseStationService.create(request);
    }
}
