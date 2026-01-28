package com.reflection.advancedlevel.customlogging;
import java.lang.reflect.Proxy;

public class ProxyDemo{
    public static void main(String[] args){
        Greeting realObj = new GreetingImple();
        Greeting proxyObj = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class[]{Greeting.class},
                new LoggingInvocationHandler(realObj)
        );
        // Call method via proxy
        proxyObj.sayHello("samarjeet");
    }
}