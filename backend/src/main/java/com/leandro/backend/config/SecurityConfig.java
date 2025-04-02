package com.leandro.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.ReferrerPolicyHeaderWriter;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

/**
 * Security configuration class
 * This class is responsible for configuring the security of the application
 * <p>
 * Key Features:
 * <ul>
 *     <li>API requests to /api/** are permitted without authentication.</li>
 *     <li>All other requests must be autheticated</li>
 *     <li>CSRF protected is disabled for simplicity in this example.</li>
 * </ul>
 *
 * @author Leandro Burgos
 * @version 0.1
 * </p>
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Configures the security filter chain for the application.
     * <p>
     * Details:
     *     <ul>
     *         <li>Disable CSRF protection using {@link AbstractHttpConfigurer#disable()} [[1]].</li>
     *         <li>Permits all requests to endpoints /api/** without authentication [[2]].</li>
     *         <li>Requires authentication for all other requests [[3]].</li>
     *     </ul>
     * </p>
     *
     * @param http the {@link HttpSecurity} object used to configure security settings.
     * @return a configured {@link SecurityFilterChain} instance.
     * @throws Exception if there is an issue configuring the security filter chain.
     */

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable) // Disable CSRF protection [[1]]
                .cors(cors -> cors.configurationSource(request -> {
                    var corsConfiguration = new CorsConfiguration();
                    corsConfiguration.setAllowedOrigins(List.of("*")); //
                    // Allow requests
                    corsConfiguration.setAllowedMethods(List.of("*")); // Allow
                    // GET, POST, PUT, PATCH, DELETE, OPTIONS methods
                    corsConfiguration.setAllowedHeaders(List.of("*")); // Allow all headers
                    return corsConfiguration;
                }))
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/api/**").permitAll() // Permit all requests to /api/** [[2]]
                        .anyRequest().authenticated() // All other requests must be authenticated [[3]]
                )
                .httpBasic(Customizer.withDefaults()); // Use HTTP Basic authentication
        return http.build();
    }
}
