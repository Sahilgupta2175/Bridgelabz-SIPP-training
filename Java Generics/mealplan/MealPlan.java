package mealplan;
public interface MealPlan {
    String getMealPlanName();
    String[] getAllowedIngredients();
    String[] getForbiddenIngredients();
    double getMinCalories();
    double getMaxCalories();
    String[] getNutritionalFocus(); 
    boolean isVegetarian();
    boolean isVegan();
}