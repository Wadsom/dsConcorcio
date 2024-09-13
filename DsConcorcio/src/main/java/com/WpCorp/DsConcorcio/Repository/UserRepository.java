package com.WpCorp.DsConcorcio.Repository;

import com.WpCorp.DsConcorcio.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}
