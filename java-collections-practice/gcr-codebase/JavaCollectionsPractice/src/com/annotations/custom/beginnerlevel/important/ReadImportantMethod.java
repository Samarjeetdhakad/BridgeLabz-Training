package com.annotations.custom.beginnerlevel.important;

import java.lang.reflect.Method;

public class ReadImportantMethod {
    public static void main(String[] args){
        Class<Service> cls = Service.class;
        for (Method method : cls.getDeclaredMethods()){
            if (method.isAnnotationPresent(ImportantMethod.class)){
                ImportantMethod im =  method.getAnnotation(ImportantMethod.class);
                System.out.println("Method Name: " + method.getName() + ", Level: " + im.level());
            }
        }
    }
}