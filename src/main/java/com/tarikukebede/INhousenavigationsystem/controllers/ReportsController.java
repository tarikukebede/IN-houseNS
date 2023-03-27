package com.tarikukebede.INhousenavigationsystem.controllers;

import com.tarikukebede.INhousenavigationsystem.dtos.ReportInDto;
import com.tarikukebede.INhousenavigationsystem.services.ReportService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Tag(name = "Report")
@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportsController {

    private final ReportService reportService;

    @PostMapping
    public void create(@Valid @RequestBody ReportInDto request){
        reportService.createReport(request);
    }
}
