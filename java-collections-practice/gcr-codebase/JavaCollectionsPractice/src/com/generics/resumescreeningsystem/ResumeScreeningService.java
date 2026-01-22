package com.generics.resumescreeningsystem;
class ResumeScreeningService {

    public static <T extends JobRole> void screenResume(Resume<T> resume) {

        System.out.println("Screening resume for: " +
                resume.getCandidateName() +
                " | Role: " + resume.getJobRole().getRoleName());

        if (resume.getExperience() >= resume.getJobRole().getMinimumExperience()) {
            System.out.println("Status: Shortlisted");
        } else {
            System.out.println("Status: Rejected");
        }
    }
}
