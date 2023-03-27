package com.tarikukebede.INhousenavigationsystem.Services;

import com.tarikukebede.INhousenavigationsystem.dtos.LocationOutDto;
import com.tarikukebede.INhousenavigationsystem.entities.MobileStation;
import com.tarikukebede.INhousenavigationsystem.services.LocationService;
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

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LocationServiceTest {

    @InjectMocks
    private LocationService underTest;

    @Mock
    private MobileStationService mobileStationService;


    @Test
    void testGet(){
        MobileStation mobileStation = new MobileStation();
        mobileStation.setId(UUID.randomUUID());
        mobileStation.setId(UUID.randomUUID());
        mobileStation.setLastKnownY(1f);
        mobileStation.setLastKnownX(1f);
        LocationOutDto outDto = Transform.toLocationOut(mobileStation);

        when(mobileStationService.get(any(UUID.class))).thenReturn(mobileStation);
        LocationOutDto result = underTest.get(mobileStation.getId());
        assertThat(result).isEqualTo(outDto);

        when(mobileStationService.get(any(UUID.class))).thenThrow(ResponseStatusException.class);
        assertThrows(ResponseStatusException.class, ()-> underTest.get(mobileStation.getId()));
    }
}
