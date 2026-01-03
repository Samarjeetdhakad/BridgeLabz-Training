package com.inheritance.multilevelinheritance.educationalcoursehierarchy;

class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;

    double calculateFinalFee() {
        return fee - (fee * discount / 100);
    }

    void displayPaidCourse() {
        displayOnlineCourse();
        System.out.println("Course Fee: ₹" + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Fee: ₹" + calculateFinalFee());
    }
}

