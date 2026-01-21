package com.generics.mealplangenerator;
class MealPlanGenerator {

    public static <T extends MealPlan> Meal<T> generateMealPlan(T mealPlan) {

        System.out.println("Validating meal plan for: " + mealPlan.getMealType());

        if (mealPlan.getCalories() <= 0) {
            throw new IllegalArgumentException("Invalid calorie value");
        }

        return new Meal<>(mealPlan);
    }
}
