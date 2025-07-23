package marketplace;
import java.util.*;
public class OnlineMarketplace {
    private ProductCatalog catalog;
    private String marketplaceName;
    public OnlineMarketplace(String marketplaceName) {
        this.marketplaceName = marketplaceName;
        this.catalog = new ProductCatalog("Main Catalog");
    }
    public <T extends ProductCategory> Product<T> createAndAddProduct(
            String productId, String name, String description, double price,
            int stockQuantity, T category, String sellerId) {
        Product<T> product = new Product<>(productId, name, description, price,
                stockQuantity, category, sellerId);
        catalog.addProduct(product);
        return product;
    }
    public <T extends ProductCategory> void applySeasonalDiscount(
            String categoryName, double discountPercentage) {
        System.out.println(String.format("\n=== APPLYING %.1f%% SEASONAL DISCOUNT TO %s ===",
                discountPercentage, categoryName.toUpperCase()));
        List<Product<? extends ProductCategory>> categoryProducts = catalog.findProductsByCategory(categoryName);
        for (Product<? extends ProductCategory> product : categoryProducts) {
            try {
                @SuppressWarnings("unchecked")
                Product<T> typedProduct = (Product<T>) product;
                catalog.applyDiscount(typedProduct, discountPercentage);
            } catch (Exception e) {
                System.out.println("Failed to apply discount to " + product.getName() + ": " + e.getMessage());
            }
        }
    }
    public <T extends ProductCategory> void addBulkProducts(List<Product<T>> products) {
        System.out.println("\n=== ADDING BULK PRODUCTS ===");
        for (Product<T> product : products) {
            catalog.addProduct(product);
        }
        System.out.println("Added " + products.size() + " products to catalog");
    }
    public void demonstrateSearchCapabilities() {
        System.out.println("\n=== SEARCH CAPABILITIES DEMO ===");
        System.out.println("\n--- BOOKS ---");
        catalog.findProductsByCategory("Books").forEach(System.out::println);
        System.out.println("\n--- PRODUCTS UNDER $50 ---");
        catalog.findProductsByPriceRange(0, 50).forEach(System.out::println);
        System.out.println("\n--- DISCOUNTED PRODUCTS ---");
        catalog.findDiscountedProducts().forEach(System.out::println);
        System.out.println("\n--- TOP RATED PRODUCTS ---");
        catalog.getTopRatedProducts(5).forEach(System.out::println);
        System.out.println("\n--- PRODUCTS WITH 'SMART' IN NAME ---");
        catalog.searchProductsByName("smart").forEach(System.out::println);
    }
    public void displayMarketplaceInfo() {
        System.out.println("\n=== " + marketplaceName.toUpperCase() + " MARKETPLACE ===");
        catalog.displayCatalogStatistics();
        catalog.displayAllProducts();
    }
    public static void main(String[] args) {
        OnlineMarketplace marketplace = new OnlineMarketplace("TechMart");
        BookCategory bookCategory = new BookCategory();
        ClothingCategory clothingCategory = new ClothingCategory();
        GadgetCategory gadgetCategory = new GadgetCategory();
        Product<BookCategory> book1 = marketplace.createAndAddProduct(
                "B001", "Java Programming Guide", "Comprehensive guide to Java programming",
                45.99, 50, bookCategory, "BookSeller123");
        book1.addAttribute("author", "John Smith");
        book1.addAttribute("genre", "Programming");
        book1.addAttribute("pages", "500");
        book1.addReview(4.5);
        book1.addReview(4.2);
        book1.addReview(4.8);
        Product<BookCategory> book2 = marketplace.createAndAddProduct(
                "B002", "Data Structures and Algorithms", "Advanced concepts in DSA",
                55.99, 30, bookCategory, "BookSeller123");
        book2.addAttribute("author", "Jane Doe");
        book2.addAttribute("genre", "Computer Science");
        book2.addAttribute("pages", "650");
        book2.addReview(4.7);
        book2.addReview(4.9);
        Product<BookCategory> book3 = marketplace.createAndAddProduct(
                "B003", "Web Development Basics", "Learn HTML, CSS, and JavaScript",
                35.99, 75, bookCategory, "TechBooks");
        book3.addAttribute("author", "Mike Johnson");
        book3.addAttribute("genre", "Web Development");
        book3.addAttribute("pages", "400");
        book3.addReview(4.1);
        Product<ClothingCategory> clothing1 = marketplace.createAndAddProduct(
                "C001", "Smart Casual Shirt", "Cotton blend casual shirt",
                29.99, 100, clothingCategory, "FashionHub");
        clothing1.addAttribute("size", "M");
        clothing1.addAttribute("color", "Blue");
        clothing1.addAttribute("material", "Cotton");
        clothing1.addAttribute("brand", "StyleMax");
        clothing1.addReview(4.0);
        clothing1.addReview(4.3);
        Product<ClothingCategory> clothing2 = marketplace.createAndAddProduct(
                "C002", "Winter Jacket", "Warm winter jacket with hood",
                89.99, 25, clothingCategory, "WinterWear");
        clothing2.addAttribute("size", "L");
        clothing2.addAttribute("color", "Black");
        clothing2.addAttribute("material", "Polyester");
        clothing2.addAttribute("season", "Winter");
        clothing2.addReview(4.6);
        Product<ClothingCategory> clothing3 = marketplace.createAndAddProduct(
                "C003", "Summer Dress", "Light and comfortable summer dress",
                39.99, 60, clothingCategory, "SummerStyle");
        clothing3.addAttribute("size", "S");
        clothing3.addAttribute("color", "Yellow");
        clothing3.addAttribute("material", "Cotton");
        clothing3.addAttribute("season", "Summer");
        clothing3.addReview(4.4);
        Product<GadgetCategory> gadget1 = marketplace.createAndAddProduct(
                "G001", "Smart Watch", "Fitness tracking smart watch",
                199.99, 40, gadgetCategory, "TechGadgets");
        gadget1.addAttribute("brand", "TechFit");
        gadget1.addAttribute("warranty", "2 years");
        gadget1.addAttribute("connectivity", "Bluetooth");
        gadget1.addAttribute("battery", "7 days");
        gadget1.addReview(4.2);
        gadget1.addReview(4.5);
        Product<GadgetCategory> gadget2 = marketplace.createAndAddProduct(
                "G002", "Wireless Earbuds", "Noise-canceling wireless earbuds",
                79.99, 80, gadgetCategory, "AudioTech");
        gadget2.addAttribute("brand", "SoundMax");
        gadget2.addAttribute("warranty", "1 year");
        gadget2.addAttribute("connectivity", "Bluetooth 5.0");
        gadget2.addAttribute("battery", "24 hours");
        gadget2.addReview(4.0);
        Product<GadgetCategory> gadget3 = marketplace.createAndAddProduct(
                "G003", "Smart Phone Stand", "Adjustable smartphone stand",
                24.99, 150, gadgetCategory, "AccessoryPro");
        gadget3.addAttribute("brand", "StandPro");
        gadget3.addAttribute("warranty", "6 months");
        gadget3.addAttribute("material", "Aluminum");
        gadget3.addReview(3.8);
        gadget3.addReview(4.1);
        System.out.println("=== DYNAMIC ONLINE MARKETPLACE DEMO ===");
        marketplace.displayMarketplaceInfo();
        marketplace.applySeasonalDiscount("Clothing", 20.0);
        marketplace.applySeasonalDiscount("Books", 15.0);
        System.out.println("\n=== APPLYING INDIVIDUAL DISCOUNTS ===");
        marketplace.catalog.applyDiscount(gadget1, 10.0);
        marketplace.catalog.applyDiscount(book1, 25.0);
        marketplace.demonstrateSearchCapabilities();
        marketplace.displayMarketplaceInfo();
        System.out.println("\n=== BULK OPERATIONS DEMO ===");
        List<Product<BookCategory>> newBooks = Arrays.asList(
                new Product<>("B004", "Machine Learning Basics", "Introduction to ML",
                        49.99, 35, bookCategory, "MLBooks"),
                new Product<>("B005", "Python for Beginners", "Learn Python programming",
                        39.99, 45, bookCategory, "PythonBooks"));
        newBooks.get(0).addAttribute("author", "AI Expert");
        newBooks.get(0).addAttribute("genre", "Machine Learning");
        newBooks.get(1).addAttribute("author", "Python Guru");
        newBooks.get(1).addAttribute("genre", "Programming");
        marketplace.addBulkProducts(newBooks);
        marketplace.catalog.applyBulkDiscount(newBooks, 12.0);
        System.out.println("\n=== FINAL MARKETPLACE STATE ===");
        marketplace.catalog.displayCatalogStatistics();
        try {
            System.out.println("\n=== TYPE SAFETY DEMO ===");
            book1.addAttribute("isbn", "978-1234567890");
            book1.addAttribute("invalid_attr", "test");
        } catch (IllegalArgumentException e) {
            System.out.println("Type safety enforced: " + e.getMessage());
        }
        try {
            Product<BookCategory> invalidBook = new Product<>(
                    "B999", "Expensive Book", "Too expensive",
                    300.0, 10, bookCategory, "ExpensiveBooks");
        } catch (IllegalArgumentException e) {
            System.out.println("Price validation enforced: " + e.getMessage());
        }
    }
}