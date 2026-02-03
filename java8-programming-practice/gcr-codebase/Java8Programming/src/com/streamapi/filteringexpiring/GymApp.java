package com.streamapi.filteringexpiring;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class GymApp {
    public static void main(String[] args) {
        List<Member> members = Arrays.asList(
            new Member("Amit", LocalDate.now().plusDays(10)),
            new Member("Neha", LocalDate.now().plusDays(40)),
            new Member("Rahul", LocalDate.now().plusDays(25)),
            new Member("Priya", LocalDate.now().plusDays(5)),
            new Member("Karan", LocalDate.now().plusDays(60))
        );
        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);
        members.stream() .filter(m -> !m.getExpiryDate().isBefore(today) && m.getExpiryDate().isBefore(next30Days) )
               .forEach(System.out::println);
    }
}