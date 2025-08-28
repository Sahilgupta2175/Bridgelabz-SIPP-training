package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {
    private final UserRegistration ur = new UserRegistration();

    @Test
    void testValidRegistration() {
        assertDoesNotThrow(() -> ur.registerUser("john", "john@example.com", "secret1"));
    }

    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> ur.registerUser("john", "bad-email", "secret1"));
    }

    @Test
    void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () -> ur.registerUser("", "a@b.com", "secret1"));
    }
}
