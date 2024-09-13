package com.WpCorp.DsConcorcio.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tb_motocycles")
public class MotorcyclerEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "Model", length = 10, nullable = false)
    private String model;
    @Column(name = "Age", nullable = false, length = 4)
    private int age;
    @Column(name = "Plate", nullable = false, length = 7, unique = true)
    private String plate;
    @Column(name = "Color", nullable = false, length = 5)
    private String color;
    @ManyToMany(mappedBy = "motocycles")
    private Set<UserEntity> users = new HashSet<>();
}
