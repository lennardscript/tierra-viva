package com.leandro.backend.repository;

import com.leandro.backend.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing {@link CategoryEntity} entities.
 * <p>
 * This interface extends {@link JpaRepository} to provide CRUD operations
 * for the CategoryEntity class.
 * </p>
 *
 * @author Leandro Burgos
 * @version 0.1
 */

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {
    // Custom query methods can be defined here if needed
}
