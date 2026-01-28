package com.junittest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import com.junit.ListManager;

public class ListManagerTest {
   ListManager manager = new ListManager();
    @Test
    void testAddElement() {
      List<Integer> list = new ArrayList<>();
        manager.addElement(list, 10);
        assertEquals(1, list.size());
        assertTrue(list.contains(10));
    }
    @Test
    void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(10);
        manager.removeElement(list, 5);
        assertEquals(1, list.size());
        assertFalse(list.contains(5));
    }

    @Test
    void testGetSize() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, manager.getSize(list));
    }
}