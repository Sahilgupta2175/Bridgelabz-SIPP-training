package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TemperatureConverterTest {
    private final TemperatureConverter tc = new TemperatureConverter();

    @Test
    void testCtoF() {
        assertEquals(32.0, tc.celsiusToFahrenheit(0), 0.0001);
    }

    @Test
    void testFtoC() {
        assertEquals(0.0, tc.fahrenheitToCelsius(32), 0.0001);
    }
}
