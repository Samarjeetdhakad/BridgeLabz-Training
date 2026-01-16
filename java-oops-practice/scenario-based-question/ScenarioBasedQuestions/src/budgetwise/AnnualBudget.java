package budgetwise;
import java.util.Map;
class AnnualBudget extends Budget implements IAnalyzable {

    public AnnualBudget(double income, Map<String, Double> categoryLimits) {
        super(income, categoryLimits);
    }

    @Override
    public void generateReport() {
        System.out.println("ANNUAL FINANCIAL SUMMARY");
        System.out.println("Total Annual Income " + income);
        System.out.println("Total Annual Expenses" + totalExpenses);
        System.out.println("Yearly Savingss"+calculateNetSavings());
    }

    @Override
    public boolean detectOverspend() {
        return totalExpenses > income * 0.9;
    }
}
