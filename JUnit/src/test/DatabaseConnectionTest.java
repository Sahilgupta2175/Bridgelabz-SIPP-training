package com.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DatabaseConnectionTest {
    DatabaseConnection db;

    @BeforeEach
    void setup() {
        db = new DatabaseConnection();
        db.connect();
    }

    @AfterEach
    void tearDown() {
        db.disconnect();
    }

    @Test
    void testConnected() {
        assertTrue(db.isConnected());
    }

    @Test
    void testDisconnectedAfter() {
        // ensure disconnect works
        db.disconnect();
        assertFalse(db.isConnected());
    }
}
