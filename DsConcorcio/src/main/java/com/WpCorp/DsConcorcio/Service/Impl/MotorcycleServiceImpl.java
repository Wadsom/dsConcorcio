package com.WpCorp.DsConcorcio.Service.Impl;

import com.WpCorp.DsConcorcio.DTO.MotorDTO;
import com.WpCorp.DsConcorcio.DTO.RegisterMotorcycle;
import com.WpCorp.DsConcorcio.Entity.MotorcyclerEntity;
import com.WpCorp.DsConcorcio.Repository.MotorcycleRepository;
import com.WpCorp.DsConcorcio.Service.Exception.MotorPlateAlreadyExistsException;
import com.WpCorp.DsConcorcio.Service.MotorcycleService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@Log4j2
public class MotorcycleServiceImpl implements MotorcycleService {
    @Autowired
    private MotorcycleRepository motorRepository;

    @Transactional
    public URI createNewMotorcycle(RegisterMotorcycle registerMotorcycle) {
        if (motorRepository.existsByPlate(registerMotorcycle.getPlate())) {
            throw new MotorPlateAlreadyExistsException("Essa Placa já está em uso, por favor verifique e tente novamente");
        }
        MotorcyclerEntity mt = MotorcyclerEntity.builder()
                .age(registerMotorcycle.getAge())
                .color(registerMotorcycle.getColor())
                .plate(registerMotorcycle.getPlate())
                .model(registerMotorcycle.getModel())
                .build();
        motorRepository.save(mt);
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(mt.getId()).toUri();

    }

    @Override
    public Set<MotorDTO> getAllMotorcycles() {
        List<MotorcyclerEntity> entities = motorRepository.findAll();
        return entities.stream().map(MotorDTO::new).collect(Collectors.toSet());
    }
}
