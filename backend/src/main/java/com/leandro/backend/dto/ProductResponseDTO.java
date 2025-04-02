package com.leandro.backend.dto;

import lombok.Data;

/**
 * ProductResponseDTO is a Data Transfer Object (DTO) that represents the response
 * for a product.
 * It is used to transfer product data between the client and the server.
 *
 * @author Leandro Burgos
 * @version 0.1
 */
@Data
public class ProductResponseDTO {

    private Long id;
    private String name;
    private String phone;
    private String email;
    private String category;
}
