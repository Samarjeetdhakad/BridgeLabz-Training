package com.junittest;

import com.junit.Calculator; 
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    Calculator calculator = new Calculator();
    @Test
    void testAdd() {
        assertEquals(10, calculator.add(5, 5));
    }
    @Test
    void testSubtract() {
        assertEquals(0, calculator.subtract(5, 5));
    }
    @Test
    void testMultiply() {
        assertEquals(25, calculator.multiply(5, 5));
    }
    @Test
    void testDivide() {
        assertEquals(2, calculator.divide(10, 5));
    }
    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }
}