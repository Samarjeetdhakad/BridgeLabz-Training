package com.functionalinterface.passwordvalidator;

public class Main {
  public static void main(String[] args) {
	        String password1="Pass1234";
	        String password2="password";
	        String password3="Admin1";
	        System.out.println(password1 +  SecurityUtils.isStrongPassword(password1));
	        System.out.println(password2 +  SecurityUtils.isStrongPassword(password2));
	        System.out.println(password3 +  SecurityUtils.isStrongPassword(password3));
	    }
	}

