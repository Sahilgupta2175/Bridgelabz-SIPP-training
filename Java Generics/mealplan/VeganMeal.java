package mealplan;
public class VeganMeal implements MealPlan {
    @Override
    public String getMealPlanName() {
        return "Vegan";
    }
    @Override
    public String[] getAllowedIngredients() {
        return new String[] {
                "vegetables", "fruits", "grains", "legumes", "nuts", "seeds",
                "herbs", "spices", "vegetable oil", "plant-based milk",
                "tofu", "tempeh", "nutritional yeast", "maple syrup"
        };
    }
    @Override
    public String[] getForbiddenIngredients() {
        return new String[] {
                "meat", "poultry", "fish", "seafood", "dairy", "eggs",
                "honey", "gelatin", "animal fat", "meat stock", "fish sauce"
        };
    }
    @Override
    public double getMinCalories() {
        return 1200.0;
    }
    @Override
    public double getMaxCalories() {
        return 2400.0;
    }
    @Override
    public String[] getNutritionalFocus() {
        return new String[] { "plant-based", "high-fiber", "antioxidant-rich" };
    }
    @Override
    public boolean isVegetarian() {
        return true;
    }
    @Override
    public boolean isVegan() {
        return true;
    }
}