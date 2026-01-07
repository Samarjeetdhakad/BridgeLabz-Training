package loanbubby;

public class LoanBuddyApp {

    public static void main(String[] args) {

        Applicant applicant1 = new Applicant("Samarjeet",720,8000000,2000000 );

        LoanApplication loan = new HomeLoan(applicant1, 240);

        if (loan.approveLoan()) {
            System.out.println("Loan Approved ");
            System.out.println("Monthly EMI: ₹" + loan.calculateEMI());
        } else {
            System.out.println("Loan Rejected ");
        }
    }
}
