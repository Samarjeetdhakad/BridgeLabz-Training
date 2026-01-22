package com.generics.resumescreeningsystem;
class SoftwareEngineer extends JobRole {

    String getRoleName() {
        return "Software Engineer";
    }

    int getMinimumExperience() {
        return 2;
    }
}

class DataScientist extends JobRole {

    String getRoleName() {
        return "Data Scientist";
    }

    int getMinimumExperience() {
        return 3;
    }
}

class ProductManager extends JobRole {

    String getRoleName() {
        return "Product Manager";
    }

    int getMinimumExperience() {
        return 4;
    }
}
