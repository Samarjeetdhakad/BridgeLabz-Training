package com.functionalinterface.passwordvalidator;

interface SecurityUtils {
	    static boolean isStrongPassword(String password) {
	        if (password == null) {
	            return false;
	        }
	        boolean hasMinLength=password.length() >= 8;
	        boolean hasUppercase=password.matches(".*[A-Z].*");
	        boolean hasDigit=password.matches(".*\\d.*");
	        return hasMinLength && hasUppercase && hasDigit;
	    }
	}

