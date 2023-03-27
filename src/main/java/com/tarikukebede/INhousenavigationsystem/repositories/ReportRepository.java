package com.tarikukebede.INhousenavigationsystem.repositories;

import com.tarikukebede.INhousenavigationsystem.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReportRepository extends JpaRepository<Report, UUID> {
}
