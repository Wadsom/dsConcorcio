package com.WpCorp.DsConcorcio.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
@Table(name = "tb_users")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Column(name = "Name", length = 12, nullable = false)
    private String Name;
    @Column(name = "Email", length = 12, nullable = false)
    @Email
    private String Email;
    @Column(name = "Password", length = 10, nullable = false)
    private String Password;
    @ManyToMany
    @JoinTable(name = "tb_users_motocycles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id"))
    private Set<MotorcyclerEntity> motocycles = new HashSet<>();

}
