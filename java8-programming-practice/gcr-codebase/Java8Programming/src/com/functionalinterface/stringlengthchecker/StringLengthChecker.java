package com.functionalinterface.stringlengthchecker;
import java.util.List;
import java.util.function.Function;

public class StringLengthChecker{
	    public static void main(String[] args){
	        int characterLimit = 20;
	        Function<String,Integer> stringLengthFunction=message -> message.length();
	        List<String> messages=List.of("Hello","Welcome to Java","This message exceeds the limit");
	        for (String msg : messages) {
	            int length=stringLengthFunction.apply(msg);
	            if (length > characterLimit) {
	                System.out.println("Message too long(" + length + " chars): " + msg);
	            } else {
	                System.out.println("Message accepted(" + length + " chars): " + msg);
	            }
	        }
	    }
	}

