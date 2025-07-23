package mealplan;
public class KetoMeal implements MealPlan {
    @Override
    public String getMealPlanName() {
        return "Keto";
    }
    @Override
    public String[] getAllowedIngredients() {
        return new String[] {
                "meat", "poultry", "fish", "seafood", "eggs", "cheese",
                "butter", "oil", "nuts", "seeds", "leafy greens",
                "low-carb vegetables", "avocado", "olives"
        };
    }
    @Override
    public String[] getForbiddenIngredients() {
        return new String[] {
                "grains", "rice", "pasta", "bread", "sugar", "fruits",
                "potatoes", "beans", "lentils", "high-carb vegetables"
        };
    }
    @Override
    public double getMinCalories() {
        return 1200.0;
    }
    @Override
    public double getMaxCalories() {
        return 2800.0;
    }
    @Override
    public String[] getNutritionalFocus() {
        return new String[] { "high-fat", "low-carb", "moderate-protein" };
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