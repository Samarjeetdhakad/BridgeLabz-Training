package com.streamapi.filteringexpiring;

import java.time.LocalDate;

public class Member {
    private String name;
    private LocalDate expiryDate;
    public Member(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }
    public String getName() {
        return name;
    }
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
    @Override
    public String toString() {
        return name + " | Expiry: " + expiryDate;
    }
}