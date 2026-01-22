package com.generics.resumescreeningsystem;
import java.util.List;

class ScreeningPipeline {

    public static void processRoles(List<? extends JobRole> roles) {

        for (JobRole role : roles) {
            System.out.println("AI Model loaded for role: " + role.getRoleName());
        }
    }
}
