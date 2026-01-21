package com.generics.mealplangenerator;
class Meal<T extends MealPlan> {

    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public void showMealDetails() {
        System.out.println(
            "Meal Type: " + mealPlan.getMealType() +
            " | Calories: " + mealPlan.getCalories()
        );
    }

    public T getMealPlan() {
        return mealPlan;
    }
}
