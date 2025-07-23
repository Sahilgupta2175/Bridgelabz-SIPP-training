package mealplan;
public class VegetarianMeal implements MealPlan {
    @Override
    public String getMealPlanName() {
        return "Vegetarian";
    }
    @Override
    public String[] getAllowedIngredients() {
        return new String[] {
                "vegetables", "fruits", "grains", "legumes", "nuts", "seeds",
                "dairy", "eggs", "herbs", "spices", "vegetable oil", "honey"
        };
    }
    @Override
    public String[] getForbiddenIngredients() {
        return new String[] {
                "meat", "poultry", "fish", "seafood", "gelatin", "animal fat",
                "meat stock", "fish sauce", "anchovies"
        };
    }
    @Override
    public double getMinCalories() {
        return 1200.0;
    }
    @Override
    public double getMaxCalories() {
        return 2500.0;
    }
    @Override
    public String[] getNutritionalFocus() {
        return new String[] { "balanced-nutrition", "high-fiber", "vitamin-rich" };
    }
    @Override
    public boolean isVegetarian() {
        return true;
    }
    @Override
    public boolean isVegan() {
        return false;
    }
}