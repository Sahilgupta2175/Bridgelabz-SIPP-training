package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateFormatterTest {
    private final DateFormatter df = new DateFormatter();

    @Test
    void testFormatValid() {
        assertEquals("31-12-2020", df.formatDate("2020-12-31"));
    }

    @Test
    void testFormatInvalid() {
        assertThrows(IllegalArgumentException.class, () -> df.formatDate("12/31/2020"));
    }
}
