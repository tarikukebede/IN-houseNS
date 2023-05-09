package com.tarikukebede.INhousenavigationsystem.repositories;

import com.tarikukebede.INhousenavigationsystem.entities.Detection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DetectionRepository extends JpaRepository<Detection, UUID> {

    @Query("SELECT d FROM Detection d " +
            "JOIN Report r ON d.report = r.id " +
            "JOIN BaseStation b ON r.baseStation = b.id " +
            "WHERE d.mobileStation.id = :mobileStationId " +
            "AND (b.id, d.timeStamp) IN (SELECT b2.id, MAX(d2.timeStamp) FROM Detection d2 " +
            "JOIN Report r2 ON d2.report = r2.id " +
            "JOIN BaseStation b2 ON r2.baseStation = b2.id " +
            "WHERE d2.mobileStation.id = :mobileStationId GROUP BY b2.id)")
    Page<Detection> findRecentDetections(@Param("mobileStationId") UUID mobileStationId, Pageable pageable);
}
