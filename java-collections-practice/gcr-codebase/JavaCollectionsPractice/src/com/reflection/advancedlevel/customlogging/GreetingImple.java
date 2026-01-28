package com.reflection.advancedlevel.customlogging;
public class GreetingImple implements Greeting {

    @Override
    public void sayHello(String name) {
        System.out.println("Hello, " + name + " ");
    }
}