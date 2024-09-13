package com.WpCorp.DsConcorcio.Service;

import com.WpCorp.DsConcorcio.DTO.MotorDTO;
import com.WpCorp.DsConcorcio.DTO.RegisterMotorcycle;

import java.net.URI;
import java.util.Set;

public interface MotorcycleService {

    public URI createNewMotorcycle(RegisterMotorcycle registerMotorcycle);
    public Set<MotorDTO> getAllMotorcycles();

}
