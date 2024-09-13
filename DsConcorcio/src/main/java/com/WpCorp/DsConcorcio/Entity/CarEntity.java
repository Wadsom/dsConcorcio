package com.WpCorp.DsConcorcio.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tb_cars")
public class CarEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Column(name = "Model", length = 10, nullable = false)
    private String model;
    @Column(name = "Age", nullable = false, length = 4)
    private long age;
    @Column(name = "Plate", nullable = false, length = 7)
    private String plate;
    @Column(name = "Color", nullable = false, length = 5)
    private String color;


}
