package com.tarikukebede.INhousenavigationsystem.controllers;

import com.tarikukebede.INhousenavigationsystem.dtos.LocationOutDto;
import com.tarikukebede.INhousenavigationsystem.services.LocationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Tag(name = "Location")
@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
public class LocationController {
    private final LocationService service;

    @GetMapping("/{id}")
    public LocationOutDto get(@PathVariable UUID id) {
        return service.get(id);
    }
}
