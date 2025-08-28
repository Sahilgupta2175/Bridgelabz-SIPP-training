package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {
    private final PasswordValidator pv = new PasswordValidator();

    @Test
    void testValidPassword() {
        assertTrue(pv.isValid("Abcd1234"));
    }

    @Test
    void testInvalidPasswordShort() {
        assertFalse(pv.isValid("A1b2"));
    }

    @Test
    void testInvalidPasswordNoUpper() {
        assertFalse(pv.isValid("abcd1234"));
    }
}
