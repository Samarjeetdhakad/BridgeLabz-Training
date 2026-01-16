package budgetwise;

import java.util.*;

 class Budget {
    protected double income;
    protected double totalExpenses;
    protected Map<String, Double> categoryLimits;

     Budget(double income, Map<String, Double> categoryLimits) {
        this.income = income;
        this.categoryLimits = categoryLimits;
        this.totalExpenses = 0;
    }


    public void addExpense(double amount, String category) {
        totalExpenses += amount;
    }

   
    public double calculateNetSavings() {
        return income - totalExpenses;
    }
}
