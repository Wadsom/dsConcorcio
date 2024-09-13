package com.WpCorp.DsConcorcio.Service.Impl;

import com.WpCorp.DsConcorcio.DTO.RegisterMotorcycle;
import com.WpCorp.DsConcorcio.DTO.RespMotorDTO;
import com.WpCorp.DsConcorcio.Entity.MotorcyclerEntity;
import com.WpCorp.DsConcorcio.Repository.MotorcycleRepository;
import com.WpCorp.DsConcorcio.Service.Exception.MotorPlateAlreadyExistsException;
import com.WpCorp.DsConcorcio.Service.MotorcycleService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Log4j2
public class MotorcycleServiceImpl implements MotorcycleService {
    @Autowired
    private MotorcycleRepository motorRepository;

    @Transactional
    public RespMotorDTO createNewMotorcycle(RegisterMotorcycle registerMotorcycle) {
        if (motorRepository.existsByPlate(registerMotorcycle.getPlate())) {
            throw new MotorPlateAlreadyExistsException("Essa Placa já está em uso, por favor verifique e tente novamente");
        }
        try {

            MotorcyclerEntity mt = MotorcyclerEntity.builder()
                    .age(registerMotorcycle.getAge())
                    .color(registerMotorcycle.getColor())
                    .plate(registerMotorcycle.getPlate())
                    .model(registerMotorcycle.getModel())
                    .build();
            mt = motorRepository.save(mt);
            return new RespMotorDTO(mt.getId());

        } catch (Exception e) {
            log.info("Error Context: {}", e.getMessage());
        }


        return null;
    }
}
