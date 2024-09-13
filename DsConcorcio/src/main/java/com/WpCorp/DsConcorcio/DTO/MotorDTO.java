package com.WpCorp.DsConcorcio.DTO;

import com.WpCorp.DsConcorcio.Entity.MotorcyclerEntity;
import lombok.Value;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link com.WpCorp.DsConcorcio.Entity.MotorcyclerEntity}
 */
@Value
public class MotorDTO implements Serializable {
    UUID id;
    String model;
    int age;
    String plate;
    String color;

    public MotorDTO(MotorcyclerEntity mt) {
        this.id = mt.getId();
        this.model = mt.getModel();
        this.age = mt.getAge();
        this.plate = mt.getPlate();
        this.color = mt.getColor();
    }
}