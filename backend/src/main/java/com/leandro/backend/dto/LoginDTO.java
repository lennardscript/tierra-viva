package com.leandro.backend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * Data Transfer Object (DTO) for user login.
 * <p>
 *     This class is used to receive user login data from the client.
 *     It contains the email and password of the user.
 * </p>
 *
 * @author Leandro Burgos
 * @version 0.1
 */
@Data
public class LoginDTO {

    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;
}
