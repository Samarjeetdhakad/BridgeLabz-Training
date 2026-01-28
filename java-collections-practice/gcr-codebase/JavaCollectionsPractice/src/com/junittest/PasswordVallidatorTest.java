package com.junittest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.junit.PasswordValidator;

public class PasswordVallidatorTest {
    PasswordValidator validator = new PasswordValidator();
    @Test
    void testValidPassword() {
        assertTrue(validator.isValid("StrongPass1"));
    }
    @Test
    void testPasswordTooShort() {
        assertFalse(validator.isValid("Abc1"));
    }
    @Test
    void testPasswordWithoutUppercase() {
        assertFalse(validator.isValid("password1"));
    }
    @Test
    void testPasswordWithoutDigit() {
        assertFalse(validator.isValid("Password"));
    }
    @Test
    void testNullPassword() {
        assertFalse(validator.isValid(null));
    }
}