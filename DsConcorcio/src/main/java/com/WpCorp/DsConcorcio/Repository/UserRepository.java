package com.WpCorp.DsConcorcio.Repository;

import com.WpCorp.DsConcorcio.Entity.UserEntity;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByEmail(@Param(value = "email") String email);

    @Query("select (count(u) > 0) from UserEntity u where u.email = ?1")
    boolean existsByEmail(@Email String email);
}
