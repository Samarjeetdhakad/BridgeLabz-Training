package com.annotations.advancedlevel.rolebased;

public class RoleValidator {
    public static void execute(Object obj, String currentUserRole){
        Class<?> cls = obj.getClass();
        if (cls.isAnnotationPresent(RoleAllowed.class)){
            RoleAllowed roleAllowed =
                    cls.getAnnotation(RoleAllowed.class);
            String allowedRole = roleAllowed.value();
            if (!allowedRole.equals(currentUserRole)) {
                System.out.println("Access Denied!");
                return;
            }
        }
        // Access granted
        try {
            cls.getMethod("deleteUser").invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}