package com.annotations.suppresswarnings;

import java.util.ArrayList;
public class SuppressWarningExample {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("Java");
        list.add(100);   
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}