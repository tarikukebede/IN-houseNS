package com.tarikukebede.INhousenavigationsystem.repositories;

import com.tarikukebede.INhousenavigationsystem.entities.MobileStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MobileStationRepository extends JpaRepository<MobileStation, UUID> {
}
