package loanbubby;

public abstract class LoanApplication implements IApprovable {

    protected Applicant applicant;
    protected int tenureMonths;
    protected double interestRate;

    private boolean approved;  
    
    public LoanApplication(Applicant applicant, int tenureMonths, double interestRate) {
        this.applicant = applicant;
        this.tenureMonths = tenureMonths;
        this.interestRate = interestRate;
    }

    
    protected boolean basicEligibilityCheck() {
        return applicant.getCreditScore() >= 650 &&
               applicant.getIncome() >= (applicant.getLoanAmount() / 10);
    }

    protected void setApproved(boolean status) {
        this.approved = status;
    }

    public boolean isApproved() {
        return approved;
    }
}
