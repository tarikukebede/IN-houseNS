package com.tarikukebede.INhousenavigationsystem.controllers;

import com.tarikukebede.INhousenavigationsystem.dtos.MobileStationInDto;
import com.tarikukebede.INhousenavigationsystem.services.MobileStationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@Tag(name = "Mobile Station")
@RestController
@RequestMapping("/mobile_stations")
@RequiredArgsConstructor
public class MobileStationController {

    private final MobileStationService service;

    @PostMapping
    public UUID create(@Valid @RequestBody  MobileStationInDto request){
        return service.create(request);
    }
}
