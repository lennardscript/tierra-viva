package com.leandro.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Represents a product
 * This entity is mapped to the 'product' table in database
 *
 * @author Leandro Burgos
 * @version 0.1
 */
@Data
@Entity
@Table(name = "product")
public class ProductEntity {

    /**
     * Unique identifier for the product
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name of the product
     */
    @Column(nullable = false)
    private String nameProduct;

    /**
     * Description of the product
     */
    @Column(nullable = false)
    private String description;

    /**
     * Price of the product
     */
    @Column(nullable = false)
    private Double price;

    /**
     * Stock of the product
     */
    @Column(nullable = false)
    private Integer stock;

    /**
     * Category associated with the product.
     */
    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private CategoryEntity category;
}
