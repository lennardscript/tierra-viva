package com.leandro.backend.exception;

/**
 * Custom exception class to handle resource not found scenarios.
 * This exception is thrown when a requested resource is not found in the system.
 *
 * @author Leandro Burgos
 * @version 0.1
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
