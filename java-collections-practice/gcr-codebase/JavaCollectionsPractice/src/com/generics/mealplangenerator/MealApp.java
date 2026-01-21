package com.generics.mealplangenerator;
public class MealApp {

    public static void main(String[] args) {

        Meal<VegetarianMeal> vegMeal =
                MealPlanGenerator.generateMealPlan(new VegetarianMeal());

        Meal<KetoMeal> ketoMeal =
                MealPlanGenerator.generateMealPlan(new KetoMeal());

        Meal<HighProteinMeal> proteinMeal =
                MealPlanGenerator.generateMealPlan(new HighProteinMeal());

        vegMeal.showMealDetails();
        ketoMeal.showMealDetails();
        proteinMeal.showMealDetails();
    }
}
