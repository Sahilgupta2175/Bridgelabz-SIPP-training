package com.example;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ListManagerTest {
    private final ListManager lm = new ListManager();

    @Test
    void testAddElement() {
        List<Integer> list = new ArrayList<>();
        lm.addElement(list, 5);
        assertTrue(list.contains(5));
        assertEquals(1, lm.getSize(list));
    }

    @Test
    void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        boolean removed = lm.removeElement(list, 3);
        assertTrue(removed);
        assertEquals(0, lm.getSize(list));
    }
}
