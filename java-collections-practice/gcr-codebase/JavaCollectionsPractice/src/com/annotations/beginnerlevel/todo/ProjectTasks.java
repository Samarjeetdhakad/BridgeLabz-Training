package com.annotations.beginnerlevel.todo;

public class ProjectTasks {
    @Todo(
        task = "Implement login feature",
        assignedTo = "samarjeet",
        priority = "HIGH"
    )
    public void loginFeature() {
    }
    @Todo(
        task = "Add forgot password functionality",
        assignedTo = "Amit"
    )
    public void forgotPassword() {
    }

    @Todo(
        task = "Improve UI design",
        assignedTo = "Neha",
        priority = "LOW"
    )
    public void improveUI() {
    }
}