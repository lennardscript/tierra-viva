package com.leandro.backend.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * CategoryDTO is a Data Transfer Object (DTO) that represents a category.
 * It is used to transfer category data between the client and the server.
 *
 * @author Leandro Burgos
 * @version 0.1
 */
@Data
public class CategoryDTO {

    @NotNull(message = "Name of category is required")
    @Size(min = 3, max = 100, message = "Name of category must be between 3 and 50 characters")
    private String nameCategory;

}
