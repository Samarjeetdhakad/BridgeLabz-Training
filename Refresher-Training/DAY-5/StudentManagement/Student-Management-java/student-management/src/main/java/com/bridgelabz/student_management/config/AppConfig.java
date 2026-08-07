package com.bridgelabz.student_management.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bridgelabz.student_management.model.Address;
import com.bridgelabz.student_management.model.Course;
import com.bridgelabz.student_management.model.Laptop;
import com.bridgelabz.student_management.model.Student;

@Configuration
public class AppConfig {

    // Course Bean
    @Bean
    public Course course() {
        return new Course("Spring Core", 6);
    }

    // Address Bean
    @Bean
    public Address address() {
        Address address = new Address();
        address.setCity("Bhopal");
        address.setState("Madhya Pradesh");
        return address;
    }

    // Laptop Bean
    @Bean
    public Laptop laptop() {
        Laptop laptop = new Laptop();
        laptop.setBrand("Dell");
        laptop.setRam(16);
        return laptop;
    }

    // Student Bean
    @Bean
    public Student student() {
        Student student = new Student(  101,"Samar", course());      // Constructor Injection
        student.setAddress(address()); // Setter Injection
        return student;
    }
}