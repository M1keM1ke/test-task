package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirPlaneDto;
import com.mcb.creditfactory.external.ExternalApproveService;
import com.mcb.creditfactory.model.Airplane;
import com.mcb.creditfactory.repository.AirPlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirPlaneServiceImpl implements AirPlaneService {
    @Autowired
    private ExternalApproveService approveService;
    @Autowired
    private AirPlaneRepository airPlaneRepository;

    @Override
    public boolean approve(AirPlaneDto dto) {
        return approveService.approve(new AirPlaneAdapter(dto)) == 0;
    }

    @Override
    public Airplane save(Airplane airplane) {
        return airPlaneRepository.save(airplane);
    }

    @Override
    public Optional<Airplane> load(Long id) {
        return airPlaneRepository.findById(id);
    }

    @Override
    public Airplane fromDto(AirPlaneDto dto) {
        return new Airplane(
                dto.getId(),
                dto.getBrand(),
                dto.getModel(),
                dto.getManufacturer(),
                dto.getYear(),
                dto.getFuel(),
                dto.getSeats(),
                dto.getValue()
        );
    }

    @Override
    public AirPlaneDto toDTO(Airplane airplane) {
        return new AirPlaneDto(
                airplane.getId(),
                airplane.getBrand(),
                airplane.getModel(),
                airplane.getManufacturer(),
                airplane.getYear(),
                airplane.getFuel(),
                airplane.getSeats(),
                airplane.getValue()
        );
    }

    @Override
    public Long getId(Airplane airplane) {
        return airplane.getId();
    }
}
