package com.leandro.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entity class representing a category in the database.
 * This class is mapped to the "category" table.
 *
 * @author Leandro Burgos
 * @version 0.1
 */

@Data
@Entity
@Table(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameCategory;

}
