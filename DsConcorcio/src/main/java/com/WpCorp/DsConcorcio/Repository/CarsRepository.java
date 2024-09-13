package com.WpCorp.DsConcorcio.Repository;

import com.WpCorp.DsConcorcio.Entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarsRepository extends JpaRepository<CarEntity, UUID> {
}
