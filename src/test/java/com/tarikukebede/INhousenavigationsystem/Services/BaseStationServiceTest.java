package com.tarikukebede.INhousenavigationsystem.Services;

import com.tarikukebede.INhousenavigationsystem.entities.BaseStation;
import com.tarikukebede.INhousenavigationsystem.repositories.BaseStationRepository;
import com.tarikukebede.INhousenavigationsystem.services.BaseStationService;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BaseStationServiceTest {

    @InjectMocks
    private BaseStationService underTest;

    @Mock
    private BaseStationRepository repository;


    @Test
    void testCreate(){
        BaseStation baseStation = new BaseStation();
        baseStation.setName("Test");
        baseStation.setX(1f);
        baseStation.setY(1f);
        baseStation.setDetectionRadiusInMeters(1f);

        when(repository.save(any(BaseStation.class))).thenReturn(baseStation);
        BaseStation result = underTest.create(baseStation);
        assertThat(result).isEqualTo(baseStation);
    }

    @Test
    void testGet(){
        BaseStation baseStation = new BaseStation();
        baseStation.setId(UUID.randomUUID());
        baseStation.setName("Test");
        baseStation.setX(1f);
        baseStation.setY(1f);
        baseStation.setDetectionRadiusInMeters(1f);

        when(repository.findById(any(UUID.class))).thenReturn(Optional.of(baseStation));
        BaseStation result = underTest.get(baseStation.getId());
        assertThat(result).isEqualTo(baseStation);

        when(repository.findById(any(UUID.class))).thenReturn(Optional.empty());
        assertThrows(ResponseStatusException.class, ()-> underTest.get(baseStation.getId()));
    }
}
