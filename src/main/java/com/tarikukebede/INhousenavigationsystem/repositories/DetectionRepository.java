package com.tarikukebede.INhousenavigationsystem.repositories;

import com.tarikukebede.INhousenavigationsystem.entities.Detection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DetectionRepository extends JpaRepository<Detection, UUID> {
}
