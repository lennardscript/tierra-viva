package com.leandro.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * Data Transfer Object (DTO) for user registration
 * <p>
 *     This class is used to receive user registration data from the client.
 *     It contains the username, password, and email of the user.
 * </p>
 *
 * @author Leandro Burgos
 * @version 0.1
 */
@Data
public class UserDTO {

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Email is required")
    private String email;
}
