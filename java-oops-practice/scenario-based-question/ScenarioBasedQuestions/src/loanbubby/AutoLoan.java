package loanbubby;

public class AutoLoan extends LoanApplication {

    public AutoLoan(Applicant applicant, int tenureMonths) {
        super(applicant, tenureMonths, 10.0); // auto loan interest
    }

    @Override
    public boolean approveLoan() {
        boolean eligible = basicEligibilityCheck() &&
                           applicant.getCreditScore() >= 680;
        setApproved(eligible);
        return eligible;
    }

    @Override
    public double calculateEMI() {
        double P = applicant.getLoanAmount();
        double R = interestRate / (12 * 100);
        int N = tenureMonths;

        return (P * R * Math.pow(1 + R, N)) /
               (Math.pow(1 + R, N) - 1);
    }
}
