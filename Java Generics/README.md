# Java Generics - Comprehensive Solutions

This project contains complete implementations of 5 advanced Java Generics problems that demonstrate Generic Classes, Bounded Type Parameters, Wildcards, and Generic Methods.

## 🎯 Problems Covered

### 1. Smart Warehouse Management System
**Location**: `src/warehouse/`
**Concepts**: Generic Classes, Bounded Type Parameters, Wildcards

**Features**:
- Generic `Storage<T extends WarehouseItem>` class for type-safe storage
- Abstract `WarehouseItem` base class with concrete implementations (Electronics, Groceries, Furniture)
- Wildcard methods for handling multiple item types
- Inventory management with automated cost calculations

**Key Files**:
- `WarehouseItem.java` - Abstract base class
- `Electronics.java`, `Groceries.java`, `Furniture.java` - Concrete implementations
- `Storage.java` - Generic storage container
- `WarehouseManagementSystem.java` - Main demonstration

### 2. Dynamic Online Marketplace
**Location**: `src/marketplace/`
**Concepts**: Type Parameters, Generic Methods, Bounded Type Parameters

**Features**:
- Generic `Product<T extends ProductCategory>` class with category validation
- Multiple product categories (Books, Clothing, Gadgets) with price constraints
- Generic methods for discount application and bulk operations
- Type-safe product catalog management

**Key Files**:
- `ProductCategory.java` - Interface for categories
- `BookCategory.java`, `ClothingCategory.java`, `GadgetCategory.java` - Category implementations
- `Product.java` - Generic product class
- `ProductCatalog.java` - Catalog management
- `OnlineMarketplace.java` - Main demonstration

### 3. Multi-Level University Course Management System
**Location**: `src/university/`
**Concepts**: Generic Classes, Wildcards, Bounded Type Parameters

**Features**:
- Abstract `CourseType` with implementations (ExamCourse, AssignmentCourse, ResearchCourse)
- Generic `Course<T extends CourseType>` class for different evaluation methods
- Wildcard methods for handling diverse course types
- Student enrollment with prerequisite checking

**Key Files**:
- `CourseType.java` - Abstract course type
- `ExamCourse.java`, `AssignmentCourse.java`, `ResearchCourse.java` - Concrete types
- `Course.java` - Generic course class
- `CourseManagementSystem.java` - Main demonstration

### 4. Personalized Meal Plan Generator
**Location**: `src/mealplan/`
**Concepts**: Generic Methods, Type Parameters, Bounded Type Parameters

**Features**:
- `MealPlan` interface with implementations (Vegetarian, Vegan, Keto, HighProtein)
- Generic `Meal<T extends MealPlan>` class with ingredient validation
- Generic methods for meal plan generation and validation
- Nutritional analysis and dietary restriction compliance

**Key Files**:
- `MealPlan.java` - Interface for meal plans
- `VegetarianMeal.java`, `VeganMeal.java`, `KetoMeal.java`, `HighProteinMeal.java` - Plan types
- `Meal.java` - Generic meal class
- `MealPlanGenerator.java` - Main demonstration

### 5. AI-Driven Resume Screening System
**Location**: `src/resume/`
**Concepts**: Generic Classes, Generic Methods, Bounded Type Parameters, Wildcards

**Features**:
- Abstract `JobRole` with implementations (SoftwareEngineer, DataScientist, ProductManager)
- Generic `Resume<T extends JobRole>` class with AI scoring
- Wildcard methods for batch processing across different roles
- Automated screening and interview scheduling

**Key Files**:
- `JobRole.java` - Abstract job role
- `SoftwareEngineer.java`, `DataScientist.java`, `ProductManager.java` - Role implementations
- `Resume.java` - Generic resume class
- `ResumeScreeningSystem.java` - Main demonstration

## 🚀 How to Run

### Individual Demos
Each package contains a main class that can be run independently:

```bash
# Warehouse Management System
java -cp src warehouse.WarehouseManagementSystem

# Online Marketplace
java -cp src marketplace.OnlineMarketplace

# Course Management System
java -cp src university.CourseManagementSystem

# Meal Plan Generator
java -cp src mealplan.MealPlanGenerator

# Resume Screening System
java -cp src resume.ResumeScreeningSystem
```

### All Demos Together
Run the comprehensive demonstration:

```bash
java -cp src JavaGenericsDemo
```

## 🎓 Key Learning Outcomes

### Generic Classes
- **Bounded Type Parameters**: `<T extends SomeClass>` ensures type safety
- **Multiple Bounds**: `<T extends Class1 & Interface1>` for complex constraints
- **Type Erasure**: Understanding how generics work at runtime

### Wildcards
- **Upper Bounded**: `List<? extends Type>` for reading
- **Lower Bounded**: `List<? super Type>` for writing
- **Unbounded**: `List<?>` for maximum flexibility

### Generic Methods
- **Method-level Generics**: `<T> void method(T param)`
- **Bounded Method Parameters**: `<T extends Comparable<T>>`
- **Generic Return Types**: `<T> T getValue()`

### Type Safety Benefits
- **Compile-time Checking**: Prevents ClassCastException
- **Code Reusability**: Same logic for different types
- **Performance**: No boxing/unboxing for primitives

## 🏗️ Design Patterns Used

1. **Template Method Pattern**: Abstract classes with concrete implementations
2. **Strategy Pattern**: Different algorithms for different types
3. **Factory Pattern**: Creating objects based on generic types
4. **Observer Pattern**: Status updates and notifications

## 🔧 Advanced Features

### Type Safety Validation
- Ingredient validation in meal plans
- Price range validation in products
- Skill matching in resume screening
- Prerequisites checking in courses

### Polymorphism with Generics
- Method overriding in generic contexts
- Interface implementations with type parameters
- Abstract method implementations

### Error Handling
- Generic exception handling
- Validation with detailed error messages
- Graceful degradation for invalid operations

## 📊 Sample Output

Each demo provides comprehensive output showing:
- Object creation and validation
- Generic method operations
- Wildcard usage examples
- Type safety enforcement
- Real-world scenario simulations

## 🎯 Best Practices Demonstrated

1. **Use Bounded Type Parameters** for type constraints
2. **Prefer Wildcards** for maximum flexibility in APIs
3. **Generic Methods** for utility operations
4. **Type Erasure Awareness** for runtime considerations
5. **Meaningful Generic Names** for code readability

## 🔍 Testing Scenarios

Each system includes test cases for:
- Valid operations with correct types
- Invalid operations showing type safety
- Edge cases and boundary conditions
- Performance with large datasets
- Error handling and recovery

---

**Author**: Generated for Bridgelabz SIPP Training  
**Date**: 2025  
**Language**: Java 8+  
**Concepts**: Advanced Java Generics
