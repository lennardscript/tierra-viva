package com.leandro.backend.controller;

import com.leandro.backend.dto.LoginDTO;
import com.leandro.backend.dto.UserDTO;
import com.leandro.backend.dto.UserResponseDTO;
import com.leandro.backend.entity.UserEntity;
import com.leandro.backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for managing user authentication.
 * <p>
 * This controller provides RESTful endpoints to register, login, and logout users.
 * It uses {@link UserService} to handle the business logic.
 * </p>
 *
 * @author Leandro Burgos
 * @version 0.1
 */
@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final UserService userService;

    /**
     * Constructor-based dependency injection.
     * <p>
     *     This constructor injects the required dependencies into the controller.
     * </p>
     * @param userService the service used to handle user operations
     */
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Registers a new user
     * <p>
     * This endpoint receives a {@link UserDTO} object, validates it, and registers
     * </p>
     *
     * @param userDTO the user data to be registered
     * @return a ResponseEntity indicating successful registration
     */
    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody UserDTO userDTO) {
        UserResponseDTO registeredUser = userService.registerUser(userDTO);
        return ResponseEntity.ok(registeredUser);
    }

    /**
     * Authenticates a user
     * <p>
     * This endpoint can be expanded in the future to return a JWT token for authentication
     * </p>
     *
     * @param loginDTO the DTO containing the user credentials
     * @return a ResponseEntity indicating successful login
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        UserEntity user = userService.loginUser(loginDTO);
        return ResponseEntity.ok("User logged in successfully " + user.getUsername());
    }

    /**
     * Logs out a user
     * <p>
     * This endpoint clears the security context, effectively logging out the user
     * </p>
     *
     * @return a ResponseEntity indicating successful logout
     */
    @PostMapping("/logout")
    public ResponseEntity<String> logout() {

        // Clear the security context
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok("User logged out successfully");
    }
}
