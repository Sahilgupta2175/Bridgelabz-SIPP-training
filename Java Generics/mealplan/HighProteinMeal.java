package mealplan;
public class HighProteinMeal implements MealPlan {
    @Override
    public String getMealPlanName() {
        return "High-Protein";
    }
    @Override
    public String[] getAllowedIngredients() {
        return new String[] {
                "lean meat", "poultry", "fish", "seafood", "eggs", "dairy",
                "protein powder", "legumes", "quinoa", "nuts", "seeds",
                "vegetables", "fruits", "whole grains"
        };
    }
    @Override
    public String[] getForbiddenIngredients() {
        return new String[] {
                "processed foods", "sugary drinks", "refined sugar",
                "white bread", "fried foods", "excessive fats"
        };
    }
    @Override
    public double getMinCalories() {
        return 1400.0;
    }
    @Override
    public double getMaxCalories() {
        return 3000.0;
    }
    @Override
    public String[] getNutritionalFocus() {
        return new String[] { "high-protein", "muscle-building", "performance" };
    }
    @Override
    public boolean isVegetarian() {
        return false;
    }
    @Override
    public boolean isVegan() {
        return false;
    }
}