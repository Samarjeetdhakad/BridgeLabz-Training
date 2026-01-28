package com.junittest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.junit.NumberUtils;
public class NumberUtilsTest {
    NumberUtils utils = new NumberUtils();
    @Test
    void testIsEvenMultipleValues() {
        int[] values = {2, 4, 6, 7, 9};
        for (int number : values) {
            boolean expected = (number % 2 == 0);
            assertEquals(expected, utils.isEven(number),
                    "Failed for number: " + number);
        }
    }
}