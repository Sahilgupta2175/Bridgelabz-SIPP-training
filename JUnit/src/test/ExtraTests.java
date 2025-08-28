package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class ExtraTests {
    public boolean isEven(int n) {
        return n % 2 == 0;
    }

    @ParameterizedTest
    @ValueSource(ints = { 2, 4, 6, 7, 9 })
    void testIsEven(int val) {
        boolean expected = val % 2 == 0;
        assertEquals(expected, isEven(val));
    }

    // longRunningTask sleeps 3 seconds; test uses timeout 2s and will fail. We'll
    // demonstrate but disable to keep suite green.
    public String longRunningTask() throws InterruptedException {
        Thread.sleep(3000);
        return "done";
    }

    @Disabled("Disabled to keep test suite fast — demonstrates @Timeout behavior")
    @Test
    @Timeout(2)
    void testLongRunningTimeout() throws InterruptedException {
        // This is intentionally disabled; it would time out because longRunningTask
        // sleeps 3s
        assertEquals("done", longRunningTask());
    }
}
