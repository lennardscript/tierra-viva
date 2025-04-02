package com.leandro.backend.dto;

import lombok.Data;

/**
 * UserResponseDTO is a Data Transfer Object (DTO) that represents the response
 * for a user.
 * It is used to transfer user data between the client and the server.
 *
 * @author Leandro Burgos
 * @version 0.1
 */
@Data
public class UserResponseDTO {
    private Long id;
    private String username;
    private String email;
}
