package com.WpCorp.DsConcorcio.Repository;

import com.WpCorp.DsConcorcio.Entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<RoleEntity, UUID> {
    RoleEntity findByType(String name);
}
