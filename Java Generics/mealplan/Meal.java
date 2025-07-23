package mealplan;
import java.util.*;
public class Meal<T extends MealPlan> {
    private String mealId;
    private String mealName;
    private T mealPlan;
    private List<String> ingredients;
    private Map<String, Double> nutritionalInfo; 
    private double calories;
    private String mealType; 
    private int preparationTime; 
    private String difficulty; 
    private List<String> cookingInstructions;
    private Map<String, String> allergenInfo;
    public Meal(String mealId, String mealName, T mealPlan, String mealType,
            int preparationTime, String difficulty) {
        this.mealId = mealId;
        this.mealName = mealName;
        this.mealPlan = mealPlan;
        this.mealType = mealType;
        this.preparationTime = preparationTime;
        this.difficulty = difficulty;
        this.ingredients = new ArrayList<>();
        this.nutritionalInfo = new HashMap<>();
        this.cookingInstructions = new ArrayList<>();
        this.allergenInfo = new HashMap<>();
        this.calories = 0.0;
    }
    public boolean addIngredient(String ingredient) {
        String[] forbidden = mealPlan.getForbiddenIngredients();
        for (String forbiddenItem : forbidden) {
            if (ingredient.toLowerCase().contains(forbiddenItem.toLowerCase())) {
                System.out.println("Ingredient '" + ingredient + "' is not allowed in " +
                        mealPlan.getMealPlanName() + " meal plan");
                return false;
            }
        }
        String[] allowed = mealPlan.getAllowedIngredients();
        boolean isAllowed = false;
        for (String allowedItem : allowed) {
            if (ingredient.toLowerCase().contains(allowedItem.toLowerCase()) ||
                    allowedItem.toLowerCase().contains(ingredient.toLowerCase())) {
                isAllowed = true;
                break;
            }
        }
        if (!isAllowed) {
            System.out.println("Ingredient '" + ingredient + "' is not in the allowed list for " +
                    mealPlan.getMealPlanName() + " meal plan");
            return false;
        }
        ingredients.add(ingredient);
        System.out.println("Added ingredient: " + ingredient);
        return true;
    }
    public void addNutritionalInfo(String nutrient, double amount) {
        nutritionalInfo.put(nutrient, amount);
        if ("calories".equalsIgnoreCase(nutrient)) {
            this.calories = amount;
        }
    }
    public boolean validateMeal() {
        List<String> violations = new ArrayList<>();
        if (calories < mealPlan.getMinCalories() || calories > mealPlan.getMaxCalories()) {
            violations.add(String.format("Calories (%.1f) outside range [%.1f - %.1f]",
                    calories, mealPlan.getMinCalories(), mealPlan.getMaxCalories()));
        }
        String[] forbidden = mealPlan.getForbiddenIngredients();
        for (String ingredient : ingredients) {
            for (String forbiddenItem : forbidden) {
                if (ingredient.toLowerCase().contains(forbiddenItem.toLowerCase())) {
                    violations.add("Contains forbidden ingredient: " + ingredient +
                            " (forbidden: " + forbiddenItem + ")");
                }
            }
        }
        if (violations.isEmpty()) {
            System.out.println("Meal '" + mealName + "' is valid for " + mealPlan.getMealPlanName() + " plan");
            return true;
        } else {
            System.out.println("Meal '" + mealName + "' validation failed:");
            violations.forEach(v -> System.out.println("  - " + v));
            return false;
        }
    }
    public void addCookingInstruction(String instruction) {
        cookingInstructions.add(instruction);
    }
    public void addAllergenInfo(String allergen, String level) {
        allergenInfo.put(allergen, level);
    }
    public boolean isSuitableFor(String dietaryRestriction) {
        switch (dietaryRestriction.toLowerCase()) {
            case "vegetarian":
                return mealPlan.isVegetarian();
            case "vegan":
                return mealPlan.isVegan();
            case "low-calorie":
                return calories < 400;
            case "high-protein":
                return Arrays.asList(mealPlan.getNutritionalFocus()).contains("high-protein");
            case "low-carb":
                return Arrays.asList(mealPlan.getNutritionalFocus()).contains("low-carb");
            default:
                return false;
        }
    }
    public double getCompatibilityScore(MealPlan otherPlan) {
        double score = 0.0;
        String[] otherAllowed = otherPlan.getAllowedIngredients();
        int compatibleIngredients = 0;
        for (String ingredient : ingredients) {
            for (String allowed : otherAllowed) {
                if (ingredient.toLowerCase().contains(allowed.toLowerCase())) {
                    compatibleIngredients++;
                    break;
                }
            }
        }
        if (!ingredients.isEmpty()) {
            score += (double) compatibleIngredients / ingredients.size() * 50;
        }
        double minOverlap = Math.max(mealPlan.getMinCalories(), otherPlan.getMinCalories());
        double maxOverlap = Math.min(mealPlan.getMaxCalories(), otherPlan.getMaxCalories());
        if (maxOverlap > minOverlap && calories >= minOverlap && calories <= maxOverlap) {
            score += 30;
        }
        if (mealPlan.isVegetarian() == otherPlan.isVegetarian()) {
            score += 10;
        }
        if (mealPlan.isVegan() == otherPlan.isVegan()) {
            score += 10;
        }
        return score;
    }
    public String getMealId() {
        return mealId;
    }
    public String getMealName() {
        return mealName;
    }
    public T getMealPlan() {
        return mealPlan;
    }
    public List<String> getIngredients() {
        return new ArrayList<>(ingredients);
    }
    public Map<String, Double> getNutritionalInfo() {
        return new HashMap<>(nutritionalInfo);
    }
    public double getCalories() {
        return calories;
    }
    public String getMealType() {
        return mealType;
    }
    public int getPreparationTime() {
        return preparationTime;
    }
    public String getDifficulty() {
        return difficulty;
    }
    public List<String> getCookingInstructions() {
        return new ArrayList<>(cookingInstructions);
    }
    public Map<String, String> getAllergenInfo() {
        return new HashMap<>(allergenInfo);
    }
    @Override
    public String toString() {
        return String.format("Meal[ID: %s, Name: %s, Plan: %s, Type: %s, Calories: %.1f, " +
                "Prep Time: %d min, Difficulty: %s, Ingredients: %d]",
                mealId, mealName, mealPlan.getMealPlanName(), mealType, calories,
                preparationTime, difficulty, ingredients.size());
    }
    public String getDetailedString() {
        StringBuilder sb = new StringBuilder();
        sb.append(toString()).append("\n");
        sb.append("Ingredients: ").append(ingredients).append("\n");
        sb.append("Nutritional Info: ").append(nutritionalInfo).append("\n");
        if (!cookingInstructions.isEmpty()) {
            sb.append("Instructions:\n");
            for (int i = 0; i < cookingInstructions.size(); i++) {
                sb.append("  ").append(i + 1).append(". ").append(cookingInstructions.get(i)).append("\n");
            }
        }
        if (!allergenInfo.isEmpty()) {
            sb.append("Allergens: ").append(allergenInfo).append("\n");
        }
        return sb.toString();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Meal<?> meal = (Meal<?>) obj;
        return Objects.equals(mealId, meal.mealId);
    }
    @Override
    public int hashCode() {
        return Objects.hash(mealId);
    }
}