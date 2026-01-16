package budgetwise;
import java.util.Map;
class MonthlyBudget extends Budget implements IAnalyzable {

     MonthlyBudget(double income, Map<String, Double> categoryLimits) {
        super(income, categoryLimits);
    }

    @Override
    public void generateReport() {
        System.out.println("MONTHLY BUDGET REPORT");
        System.out.println("Income" + income);
        System.out.println("Expenses" + totalExpenses);
        System.out.println("Savings" + calculateNetSavings());
    }

    @Override
    public boolean detectOverspend() {
        return totalExpenses > income;
    }
}
