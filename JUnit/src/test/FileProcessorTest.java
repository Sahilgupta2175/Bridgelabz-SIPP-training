package com.example;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

public class FileProcessorTest {
    private final FileProcessor fp = new FileProcessor();

    @Test
    void testWriteAndRead() throws IOException {
        String filename = "testfile.txt";
        try {
            fp.writeToFile(filename, "hello");
            assertTrue(Files.exists(Path.of(filename)));
            assertEquals("hello", fp.readFromFile(filename));
        } finally {
            Files.deleteIfExists(Path.of(filename));
        }
    }

    @Test
    void testReadNonExistent() {
        assertThrows(IOException.class, () -> fp.readFromFile("no-such-file.txt"));
    }
}
