package com.WpCorp.DsConcorcio.Entity;

import com.WpCorp.DsConcorcio.Enum.RoleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tb_role")
public class RoleEntity implements Serializable,
        GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Enumerated(EnumType.STRING)
    @Column(name = "Type", nullable = false)
    private RoleType type;

    @ManyToMany(mappedBy = "roles")
    private Set<UserEntity> users = new HashSet<>();

    public RoleEntity(RoleType type) {
        this.type = type;
    }

    @Override
    public String getAuthority() {
        return this.type.name();
    }
}
