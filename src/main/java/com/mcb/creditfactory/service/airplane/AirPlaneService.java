package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirPlaneDto;
import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.model.Airplane;
import com.mcb.creditfactory.model.Car;

import java.util.Optional;

public interface AirPlaneService {

    boolean approve(AirPlaneDto dto);
    Airplane save(Airplane airplane);
    Optional<Airplane> load(Long id);
    Airplane fromDto(AirPlaneDto dto);
    AirPlaneDto toDTO(Airplane airplane);
    Long getId(Airplane airplane);
}
