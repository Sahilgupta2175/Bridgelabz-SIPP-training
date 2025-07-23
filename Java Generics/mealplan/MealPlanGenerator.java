package mealplan;
import java.util.*;
import java.util.stream.Collectors;
public class MealPlanGenerator {
    private Map<String, List<Meal<? extends MealPlan>>> mealDatabase;
    private String generatorName;
    public MealPlanGenerator(String generatorName) {
        this.generatorName = generatorName;
        this.mealDatabase = new HashMap<>();
        initializeMealDatabase();
    }
    private void initializeMealDatabase() {
        mealDatabase.put("Vegetarian", new ArrayList<>());
        mealDatabase.put("Vegan", new ArrayList<>());
        mealDatabase.put("Keto", new ArrayList<>());
        mealDatabase.put("High-Protein", new ArrayList<>());
    }
    public <T extends MealPlan> boolean addMeal(Meal<T> meal) {
        String planName = meal.getMealPlan().getMealPlanName();
        if (!mealDatabase.containsKey(planName)) {
            mealDatabase.put(planName, new ArrayList<>());
        }
        if (meal.validateMeal()) {
            mealDatabase.get(planName).add(meal);
            System.out.println("Added meal '" + meal.getMealName() + "' to " + planName + " database");
            return true;
        } else {
            System.out.println("Failed to add meal '" + meal.getMealName() + "' - validation failed");
            return false;
        }
    }
    public <T extends MealPlan> List<Meal<T>> generatePersonalizedPlan(
            T mealPlan, int daysCount, double targetCaloriesPerDay, String[] dietaryRestrictions) {
        System.out.println(String.format("\n=== GENERATING %d-DAY %s MEAL PLAN ===",
                daysCount, mealPlan.getMealPlanName().toUpperCase()));
        System.out.println("Target Calories/Day: " + targetCaloriesPerDay);
        System.out.println("Dietary Restrictions: " + Arrays.toString(dietaryRestrictions));
        List<Meal<? extends MealPlan>> availableMeals = mealDatabase.get(mealPlan.getMealPlanName());
        if (availableMeals == null || availableMeals.isEmpty()) {
            System.out.println("No meals available for " + mealPlan.getMealPlanName() + " plan");
            return new ArrayList<>();
        }
        List<Meal<T>> filteredMeals = new ArrayList<>();
        for (Meal<? extends MealPlan> meal : availableMeals) {
            @SuppressWarnings("unchecked")
            Meal<T> typedMeal = (Meal<T>) meal;
            boolean meetsDietaryRestrictions = true;
            for (String restriction : dietaryRestrictions) {
                if (!typedMeal.isSuitableFor(restriction)) {
                    meetsDietaryRestrictions = false;
                    break;
                }
            }
            if (meetsDietaryRestrictions) {
                filteredMeals.add(typedMeal);
            }
        }
        if (filteredMeals.isEmpty()) {
            System.out.println("No meals found matching dietary restrictions");
            return new ArrayList<>();
        }
        List<Meal<T>> mealPlan_generated = new ArrayList<>();
        Random random = new Random();
        double targetCaloriesPerMeal = targetCaloriesPerDay / 3; 
        for (int day = 1; day <= daysCount; day++) {
            System.out.println("\nDay " + day + ":");
            String[] mealTypes = { "breakfast", "lunch", "dinner" };
            for (String mealType : mealTypes) {
                List<Meal<T>> mealsOfType = filteredMeals.stream()
                        .filter(meal -> meal.getMealType().equalsIgnoreCase(mealType))
                        .collect(Collectors.toList());
                if (!mealsOfType.isEmpty()) {
                    Meal<T> selectedMeal = mealsOfType.get(random.nextInt(mealsOfType.size()));
                    mealPlan_generated.add(selectedMeal);
                    System.out.println("  " + mealType.toUpperCase() + ": " + selectedMeal.getMealName() +
                            " (" + selectedMeal.getCalories() + " cal)");
                }
            }
        }
        return mealPlan_generated;
    }
    public <T extends MealPlan> boolean validateMealPlanCompatibility(
            List<Meal<T>> meals, T targetPlan) {
        System.out.println("\n=== VALIDATING MEAL PLAN COMPATIBILITY ===");
        boolean allValid = true;
        double totalCalories = 0.0;
        for (Meal<T> meal : meals) {
            if (!meal.validateMeal()) {
                allValid = false;
                System.out.println("Invalid meal: " + meal.getMealName());
            }
            totalCalories += meal.getCalories();
        }
        double minCalories = targetPlan.getMinCalories() * (meals.size() / 3.0); 
        double maxCalories = targetPlan.getMaxCalories() * (meals.size() / 3.0);
        if (totalCalories < minCalories || totalCalories > maxCalories) {
            allValid = false;
            System.out.println(String.format("Total calories (%.1f) outside recommended range [%.1f - %.1f]",
                    totalCalories, minCalories, maxCalories));
        }
        System.out.println("Meal plan validation: " + (allValid ? "PASSED" : "FAILED"));
        System.out.println("Total calories: " + totalCalories);
        return allValid;
    }
    public <T extends MealPlan> List<Meal<T>> findMealsByCriteria(
            Class<T> mealPlanClass, String mealType, int maxPrepTime, String maxDifficulty) {
        List<Meal<T>> result = new ArrayList<>();
        for (List<Meal<? extends MealPlan>> mealList : mealDatabase.values()) {
            for (Meal<? extends MealPlan> meal : mealList) {
                if (mealPlanClass.isInstance(meal.getMealPlan()) &&
                        (mealType == null || meal.getMealType().equalsIgnoreCase(mealType)) &&
                        meal.getPreparationTime() <= maxPrepTime &&
                        isDifficultyAcceptable(meal.getDifficulty(), maxDifficulty)) {
                    @SuppressWarnings("unchecked")
                    Meal<T> typedMeal = (Meal<T>) meal;
                    result.add(typedMeal);
                }
            }
        }
        return result;
    }
    private boolean isDifficultyAcceptable(String mealDifficulty, String maxDifficulty) {
        Map<String, Integer> difficultyLevels = Map.of(
                "easy", 1, "medium", 2, "hard", 3);
        return difficultyLevels.getOrDefault(mealDifficulty.toLowerCase(), 0) <= difficultyLevels
                .getOrDefault(maxDifficulty.toLowerCase(), 3);
    }
    public Map<String, Double> calculateNutritionalSummary(List<? extends Meal<? extends MealPlan>> meals) {
        Map<String, Double> summary = new HashMap<>();
        for (Meal<? extends MealPlan> meal : meals) {
            Map<String, Double> mealNutrition = meal.getNutritionalInfo();
            for (Map.Entry<String, Double> entry : mealNutrition.entrySet()) {
                summary.merge(entry.getKey(), entry.getValue(), Double::sum);
            }
        }
        return summary;
    }
    public void displayDatabaseStatistics() {
        System.out.println("\n=== MEAL DATABASE STATISTICS ===");
        System.out.println("Generator: " + generatorName);
        int totalMeals = 0;
        for (Map.Entry<String, List<Meal<? extends MealPlan>>> entry : mealDatabase.entrySet()) {
            String planName = entry.getKey();
            int count = entry.getValue().size();
            totalMeals += count;
            System.out.println(planName + ": " + count + " meals");
        }
        System.out.println("Total Meals: " + totalMeals);
    }
    public List<Meal<? extends MealPlan>> getRecommendations(MealPlan userPlan, int limit) {
        List<Meal<? extends MealPlan>> allMeals = new ArrayList<>();
        mealDatabase.values().forEach(allMeals::addAll);
        return allMeals.stream()
                .sorted((m1, m2) -> Double.compare(m2.getCompatibilityScore(userPlan),
                        m1.getCompatibilityScore(userPlan)))
                .limit(limit)
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        MealPlanGenerator generator = new MealPlanGenerator("Smart Nutrition AI");
        VegetarianMeal vegPlan = new VegetarianMeal();
        VeganMeal veganPlan = new VeganMeal();
        KetoMeal ketoPlan = new KetoMeal();
        HighProteinMeal proteinPlan = new HighProteinMeal();
        Meal<VegetarianMeal> vegBreakfast = new Meal<>("VEG001", "Vegetarian Omelet",
                vegPlan, "breakfast", 15, "easy");
        vegBreakfast.addIngredient("eggs");
        vegBreakfast.addIngredient("vegetables");
        vegBreakfast.addIngredient("cheese");
        vegBreakfast.addNutritionalInfo("calories", 350.0);
        vegBreakfast.addNutritionalInfo("protein", 20.0);
        vegBreakfast.addNutritionalInfo("carbs", 10.0);
        vegBreakfast.addCookingInstruction("Beat eggs and add vegetables");
        vegBreakfast.addCookingInstruction("Cook in pan until set");
        vegBreakfast.addCookingInstruction("Add cheese and fold");
        Meal<VegetarianMeal> vegLunch = new Meal<>("VEG002", "Quinoa Salad",
                vegPlan, "lunch", 20, "easy");
        vegLunch.addIngredient("quinoa");
        vegLunch.addIngredient("vegetables");
        vegLunch.addIngredient("nuts");
        vegLunch.addNutritionalInfo("calories", 420.0);
        vegLunch.addNutritionalInfo("protein", 15.0);
        vegLunch.addNutritionalInfo("carbs", 45.0);
        Meal<VegetarianMeal> vegDinner = new Meal<>("VEG003", "Vegetable Curry",
                vegPlan, "dinner", 30, "medium");
        vegDinner.addIngredient("vegetables");
        vegDinner.addIngredient("legumes");
        vegDinner.addIngredient("spices");
        vegDinner.addNutritionalInfo("calories", 380.0);
        vegDinner.addNutritionalInfo("protein", 18.0);
        vegDinner.addNutritionalInfo("carbs", 50.0);
        Meal<VeganMeal> veganBreakfast = new Meal<>("VGN001", "Oatmeal with Fruits",
                veganPlan, "breakfast", 10, "easy");
        veganBreakfast.addIngredient("grains");
        veganBreakfast.addIngredient("fruits");
        veganBreakfast.addIngredient("nuts");
        veganBreakfast.addNutritionalInfo("calories", 320.0);
        veganBreakfast.addNutritionalInfo("protein", 12.0);
        veganBreakfast.addNutritionalInfo("carbs", 55.0);
        Meal<VeganMeal> veganLunch = new Meal<>("VGN002", "Tofu Stir Fry",
                veganPlan, "lunch", 25, "medium");
        veganLunch.addIngredient("tofu");
        veganLunch.addIngredient("vegetables");
        veganLunch.addIngredient("vegetable oil");
        veganLunch.addNutritionalInfo("calories", 400.0);
        veganLunch.addNutritionalInfo("protein", 25.0);
        veganLunch.addNutritionalInfo("carbs", 30.0);
        Meal<KetoMeal> ketoBreakfast = new Meal<>("KETO001", "Keto Scrambled Eggs",
                ketoPlan, "breakfast", 12, "easy");
        ketoBreakfast.addIngredient("eggs");
        ketoBreakfast.addIngredient("butter");
        ketoBreakfast.addIngredient("cheese");
        ketoBreakfast.addNutritionalInfo("calories", 450.0);
        ketoBreakfast.addNutritionalInfo("protein", 25.0);
        ketoBreakfast.addNutritionalInfo("carbs", 5.0);
        ketoBreakfast.addNutritionalInfo("fat", 38.0);
        Meal<KetoMeal> ketoLunch = new Meal<>("KETO002", "Salmon with Avocado",
                ketoPlan, "lunch", 20, "medium");
        ketoLunch.addIngredient("fish");
        ketoLunch.addIngredient("avocado");
        ketoLunch.addIngredient("oil");
        ketoLunch.addNutritionalInfo("calories", 520.0);
        ketoLunch.addNutritionalInfo("protein", 35.0);
        ketoLunch.addNutritionalInfo("carbs", 8.0);
        ketoLunch.addNutritionalInfo("fat", 42.0);
        Meal<HighProteinMeal> proteinBreakfast = new Meal<>("PROT001", "Protein Pancakes",
                proteinPlan, "breakfast", 15, "medium");
        proteinBreakfast.addIngredient("eggs");
        proteinBreakfast.addIngredient("protein powder");
        proteinBreakfast.addIngredient("whole grains");
        proteinBreakfast.addNutritionalInfo("calories", 480.0);
        proteinBreakfast.addNutritionalInfo("protein", 35.0);
        proteinBreakfast.addNutritionalInfo("carbs", 40.0);
        Meal<HighProteinMeal> proteinLunch = new Meal<>("PROT002", "Grilled Chicken Salad",
                proteinPlan, "lunch", 25, "easy");
        proteinLunch.addIngredient("poultry");
        proteinLunch.addIngredient("vegetables");
        proteinLunch.addIngredient("nuts");
        proteinLunch.addNutritionalInfo("calories", 420.0);
        proteinLunch.addNutritionalInfo("protein", 40.0);
        proteinLunch.addNutritionalInfo("carbs", 20.0);
        System.out.println("=== PERSONALIZED MEAL PLAN GENERATOR DEMO ===");
        generator.addMeal(vegBreakfast);
        generator.addMeal(vegLunch);
        generator.addMeal(vegDinner);
        generator.addMeal(veganBreakfast);
        generator.addMeal(veganLunch);
        generator.addMeal(ketoBreakfast);
        generator.addMeal(ketoLunch);
        generator.addMeal(proteinBreakfast);
        generator.addMeal(proteinLunch);
        generator.displayDatabaseStatistics();
        System.out.println("\n" + "=".repeat(60));
        List<Meal<VegetarianMeal>> vegMealPlan = generator.generatePersonalizedPlan(
                vegPlan, 2, 1200.0, new String[] { "vegetarian" });
        generator.validateMealPlanCompatibility(vegMealPlan, vegPlan);
        List<Meal<KetoMeal>> ketoMealPlan = generator.generatePersonalizedPlan(
                ketoPlan, 2, 2000.0, new String[] { "low-carb" });
        generator.validateMealPlanCompatibility(ketoMealPlan, ketoPlan);
        List<Meal<HighProteinMeal>> proteinMealPlan = generator.generatePersonalizedPlan(
                proteinPlan, 2, 2200.0, new String[] { "high-protein" });
        generator.validateMealPlanCompatibility(proteinMealPlan, proteinPlan);
        System.out.println("\n=== SEARCH DEMONSTRATIONS ===");
        List<Meal<VegetarianMeal>> quickVegBreakfast = generator.findMealsByCriteria(
                VegetarianMeal.class, "breakfast", 20, "easy");
        System.out.println("\nQuick Vegetarian Breakfast Options:");
        quickVegBreakfast.forEach(meal -> System.out.println("  " + meal.toString()));
        List<Meal<KetoMeal>> easyKetoMeals = generator.findMealsByCriteria(
                KetoMeal.class, null, 30, "easy");
        System.out.println("\nEasy Keto Meals:");
        easyKetoMeals.forEach(meal -> System.out.println("  " + meal.toString()));
        System.out.println("\n=== MEAL RECOMMENDATIONS FOR VEGAN USER ===");
        List<Meal<? extends MealPlan>> recommendations = generator.getRecommendations(veganPlan, 5);
        recommendations.forEach(meal -> {
            double compatibility = meal.getCompatibilityScore(veganPlan);
            System.out.println("  " + meal.getMealName() + " - Compatibility: " +
                    String.format("%.1f%%", compatibility));
        });
        System.out.println("\n=== NUTRITIONAL SUMMARY FOR VEGETARIAN PLAN ===");
        Map<String, Double> nutritionSummary = generator.calculateNutritionalSummary(vegMealPlan);
        nutritionSummary.forEach(
                (nutrient, amount) -> System.out.println("  " + nutrient + ": " + String.format("%.1f", amount) +
                        (nutrient.equals("calories") ? " kcal" : "g")));
        System.out.println("\n=== TYPE SAFETY DEMONSTRATION ===");
        try {
            Meal<VegetarianMeal> invalidVegMeal = new Meal<>("VEG999", "Invalid Veggie Meal",
                    vegPlan, "lunch", 20, "easy");
            invalidVegMeal.addIngredient("meat"); 
            generator.addMeal(invalidVegMeal);
        } catch (Exception e) {
            System.out.println("Validation worked: " + e.getMessage());
        }
        System.out.println("\n=== DETAILED MEAL INFORMATION ===");
        System.out.println(vegBreakfast.getDetailedString());
    }
}