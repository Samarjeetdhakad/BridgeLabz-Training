package com.streamapi.hospital;

class Doctor {
    private String name;
    private String specialty;
    private boolean availableOnWeekend;
    public Doctor(String name, String specialty, boolean availableOnWeekend) {
        this.name=name;
        this.specialty=specialty;
        this.availableOnWeekend=availableOnWeekend;
    }
    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public boolean isAvailableOnWeekend() {
        return availableOnWeekend;
    }
    public String toString() {
        return name + " "+specialty;
    }
}