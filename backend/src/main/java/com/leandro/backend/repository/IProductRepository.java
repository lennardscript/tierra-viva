package com.leandro.backend.repository;

import com.leandro.backend.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing ProductsEntity entities.
 * This interface extends JpaRepository to provide CRUD operations.
 * <p>
 *     This interface is responsible for interacting with the database
 *     to perform CRUD operations on ProductEntity objects.
 *     It extends the {@link JpaRepository} interface, which provides methods for
 * </p>
 *
 * @author Leandro Burgos
 * @version 0.1
 */
public interface IProductRepository extends JpaRepository<ProductEntity, Long> {

}
