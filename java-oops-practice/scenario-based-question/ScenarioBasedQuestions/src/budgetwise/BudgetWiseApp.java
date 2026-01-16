package budgetwise;

import java.util.*;

public class BudgetWiseApp {
    public static void main(String[] args) {

        Map<String, Double>limits =new HashMap<>();
        limits.put("Food",5000.0);
        limits.put("Rent",12000.0);
        limits.put("Travel",3000.0);

        IAnalyzable myBudget=new MonthlyBudget(30000, limits);

        ((MonthlyBudget) myBudget).addExpense(7000, "Food");
        ((MonthlyBudget) myBudget).addExpense(8000, "Rent");

        myBudget.generateReport();

        if (myBudget.detectOverspend()) {
            System.out.println("You are overspending");
        } else {
            System.out.println("You are within budget.");
        }
    }
}
