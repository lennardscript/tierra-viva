package com.leandro.backend.repository;

import com.leandro.backend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository interface for managing {@link UserEntity} entities.
 * <p>
 *     This interface extends {@link JpaRepository} to provide CRUD operations
 *     for the UserEntity class.
 * </p>
 *
 * @author Leandro Burgos
 * @version 0.1
 */
public interface IUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
    Optional<UserEntity> findByEmail(String email);
}
