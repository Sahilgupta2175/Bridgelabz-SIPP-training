package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {
    private final StringUtils su = new StringUtils();

    @Test
    void testReverse() {
        assertEquals("cba", su.reverse("abc"));
    }

    @Test
    void testIsPalindromeTrue() {
        assertTrue(su.isPalindrome("Level"));
    }

    @Test
    void testIsPalindromeFalse() {
        assertFalse(su.isPalindrome("hello"));
    }

    @Test
    void testToUpperCase() {
        assertEquals("HI", su.toUpperCase("hi"));
    }
}
