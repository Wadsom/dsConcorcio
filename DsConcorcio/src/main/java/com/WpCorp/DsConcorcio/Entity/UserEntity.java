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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "name", length = 15, nullable = false)
    private String name;
    @Column(name = "Email", length = 15, nullable = false)
    @Email
    private String email;
    @Column(name = "Password", length = 255, nullable = false)
    private String password;
    @ManyToMany
    @JoinTable(name = "tb_users_motocycles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "motor_id"))
    private Set<MotorcyclerEntity> motocycles = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "tb_users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles = new HashSet<>();


}
