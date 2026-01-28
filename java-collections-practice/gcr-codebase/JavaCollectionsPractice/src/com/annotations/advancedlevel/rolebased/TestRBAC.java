package com.annotations.advancedlevel.rolebased;

public class TestRBAC {
    public static void main(String[] args) {
        AdminService service = new AdminService();
        System.out.println("User Role: USER");
        RoleValidator.execute(service, "USER");

        System.out.println("\nUser Role: ADMIN");
        RoleValidator.execute(service, "ADMIN");
    }
}