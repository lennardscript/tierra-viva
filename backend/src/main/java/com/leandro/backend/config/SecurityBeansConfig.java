package com.leandro.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Configuration class for security beans.
 * <p>
 * This class provides a bean for the {@link PasswordEncoder},
 * which is used to securely store and verify passwords.
 * </p>
 *
 * @author Leandro Burgos
 * @version 0.1
 */

@Configuration
public class SecurityBeansConfig {

    /**
     * Creates a PasswordEncoder bean for securely encoding and verifying passwords.
     * <p>
     * This method uses BCryptPasswordEncoder, a strong hashing algorithm, to encode passwords.
     * </p>
     *
     * @return a configured {@link PasswordEncoder} instance.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
