package com.junittest;

import com.junit.DateFormatter;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class DateFormatterTest {
    DateFormatter formatter = new DateFormatter();
    @Test
    void testValidDate() {
        assertEquals("21-09-2025",
                formatter.formatDate("2025-09-21"));
    }
    @Test
    void testInvalidFormat() {
        assertThrows(IllegalArgumentException.class, () -> {
            formatter.formatDate("21-09-2025");
        });
    }
    @Test
    void testInvalidDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            formatter.formatDate("2025-02-30");
        });
    }
    @Test
    void testNullInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            formatter.formatDate(null);
        });
    }
}