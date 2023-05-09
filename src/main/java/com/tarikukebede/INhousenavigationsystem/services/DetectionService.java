package com.tarikukebede.INhousenavigationsystem.services;

import com.tarikukebede.INhousenavigationsystem.entities.Detection;
import com.tarikukebede.INhousenavigationsystem.repositories.DetectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DetectionService extends ServiceTemplate<Detection, UUID> {
    private final DetectionRepository repository;

    @Autowired
    public DetectionService(DetectionRepository repository) {
        super(repository, new Detection());
        this.repository = repository;
    }

    public List<Detection> findDetectionsByMobileStationId(UUID mobileStationId) {
        try {
            return repository.findRecentDetections(mobileStationId, PageRequest.of(0, 10)).getContent();
        } catch (Exception e) {
            e.printStackTrace();
            throw errorWileProcessing(new Detection());
        }
    }
}
