package com.WpCorp.DsConcorcio.DTO;

import com.WpCorp.DsConcorcio.Entity.MotorcyclerEntity;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;

import java.io.Serializable;
import java.util.UUID;
@ToString
@Getter@AllArgsConstructor
public class RegisterMotorcycle implements Serializable {

    @Size(min = 7, max = 15)
    @NotEmpty
    String model;
   // @Max(message = "Deve conter 4 digitos", value = 5)
    int age;
    @NotNull
    @Size(message = "Deve ter 7 digitos", min = 7, max = 7)
    String plate;
    @NotNull
    String color;




    public RegisterMotorcycle(MotorcyclerEntity ent) {
        this.model = ent.getModel();
        this.age = ent.getAge();
        this.plate = ent.getPlate();
        this.color = ent.getColor();
    }

}