package com.WpCorp.DsConcorcio.Repository;

import com.WpCorp.DsConcorcio.Entity.MotorcyclerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MotorcycleRepository extends JpaRepository<MotorcyclerEntity, UUID> {
    boolean existsByPlate( String plate);
}
