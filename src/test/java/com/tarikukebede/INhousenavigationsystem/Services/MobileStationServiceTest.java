package com.tarikukebede.INhousenavigationsystem.Services;

import com.tarikukebede.INhousenavigationsystem.dtos.MobileStationInDto;
import com.tarikukebede.INhousenavigationsystem.entities.MobileStation;
import com.tarikukebede.INhousenavigationsystem.repositories.MobileStationRepository;
import com.tarikukebede.INhousenavigationsystem.services.MobileStationService;
import com.tarikukebede.INhousenavigationsystem.utils.Transform;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class MobileStationServiceTest {

    @InjectMocks
    private MobileStationService underTest;

    @Mock
    private MobileStationRepository repository;


    @Test
    void testCreate(){
        MobileStationInDto inDto = new MobileStationInDto();
        inDto.setLastKnownX(1f);
        inDto.setLastKnownY(11f);

        MobileStation mobileStation = Transform.toMobileStation(inDto);
        mobileStation.setId(UUID.randomUUID());

        when(repository.save(any(MobileStation.class))).thenReturn(mobileStation);
        UUID result = underTest.create(inDto);
        assertThat(result).isEqualTo(mobileStation.getId());
    }



    @Test
    void testGet(){
        MobileStationInDto inDto = new MobileStationInDto();
        inDto.setLastKnownX(1f);
        inDto.setLastKnownY(11f);

        MobileStation mobileStation = Transform.toMobileStation(inDto);
        mobileStation.setId(UUID.randomUUID());

        when(repository.findById(any(UUID.class))).thenReturn(Optional.of(mobileStation));
        MobileStation result = underTest.get(mobileStation.getId());
        assertThat(result).isEqualTo(mobileStation);

        when(repository.findById(any(UUID.class))).thenReturn(Optional.empty());
        assertThrows(ResponseStatusException.class, ()-> underTest.get(mobileStation.getId()));
    }
}
