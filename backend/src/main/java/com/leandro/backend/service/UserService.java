package com.leandro.backend.service;

import com.leandro.backend.dto.LoginDTO;
import com.leandro.backend.dto.UserDTO;
import com.leandro.backend.dto.UserResponseDTO;
import com.leandro.backend.entity.UserEntity;
import com.leandro.backend.repository.IUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Service class for managing users operations.
 * <p>
 * This class provides methods for user registration and authentication.
 * It uses {@link IUserRepository}
 * </p>
 */
@Service
public class UserService {

    private final IUserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    /**
     * Constructor-based dependency injection.
     * <p>
     *     This constructor injects the required dependencies into the service.
     * </p>
     * @param userRepository the repository used to interact with the database.
     * @param passwordEncoder the encoder used to securely store and verify passwords.
     */
    public UserService(IUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Registers a new user.
     * <p>
     * This method validates that the username and email,
     * encrypts the password, and saves the user to the database.
     * </p>
     *
     * @param userDTO the DTO containing the user data
     * @return a {@link UserResponseDTO} object with the registered user data
     * @throws IllegalArgumentException if the username or email already exists
     */
    public UserResponseDTO registerUser(UserDTO userDTO) {
        if (userRepository.findByUsername(userDTO.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }

        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }

        UserEntity user = new UserEntity();
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setEmail(userDTO.getEmail());

        UserEntity savedUser = userRepository.save(user);

        return mapToResponseDTO(savedUser);

    }

    /**
     * Maps a {@link UserEntity} object to a {@link UserResponseDTO}.
     * @param userEntity the entity to map
     * @return a new {@link UserResponseDTO} object with the entity data
     */
    private UserResponseDTO mapToResponseDTO(UserEntity userEntity) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(userEntity.getId());
        dto.setUsername(userEntity.getUsername());
        dto.setEmail(userEntity.getEmail());
        return dto;
    }

    /**
     * Authenticates a user.
     * <p>
     * This method verifies that username exists and that the password matches the encrypted value.
     * </p>
     *
     * @param loginDTO the DTO containing the user credentials
     * @return the {@link UserEntity} object representing the authenticated user
     * @throws IllegalArgumentException if the user is not found or the password is invalid
     */
    public UserEntity loginUser(LoginDTO loginDTO) {

        // Find the user by username
        UserEntity user = userRepository.findByEmail(loginDTO.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        // Check if the password matches
        if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }
        return user;
    }

}
