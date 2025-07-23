package marketplace;
import java.util.*;
import java.util.stream.Collectors;
public class ProductCatalog {
    private Map<String, Product<? extends ProductCategory>> products;
    private String catalogName;
    public ProductCatalog(String catalogName) {
        this.catalogName = catalogName;
        this.products = new HashMap<>();
    }
    public <T extends ProductCategory> boolean addProduct(Product<T> product) {
        if (products.containsKey(product.getProductId())) {
            System.out.println("Product with ID " + product.getProductId() + " already exists!");
            return false;
        }
        products.put(product.getProductId(), product);
        System.out.println("Added product: " + product.getName() + " to catalog");
        return true;
    }
    public <T extends ProductCategory> void applyDiscount(Product<T> product, double percentage) {
        if (!products.containsKey(product.getProductId())) {
            throw new IllegalArgumentException("Product not found in catalog");
        }
        product.applyDiscount(percentage);
    }
    public <T extends ProductCategory> void applyBulkDiscount(List<Product<T>> productList, double percentage) {
        System.out.println(String.format("\n=== APPLYING %.1f%% BULK DISCOUNT ===", percentage));
        for (Product<T> product : productList) {
            if (products.containsKey(product.getProductId())) {
                try {
                    applyDiscount(product, percentage);
                } catch (Exception e) {
                    System.out.println("Failed to apply discount to " + product.getName() + ": " + e.getMessage());
                }
            }
        }
    }
    public List<Product<? extends ProductCategory>> findProductsByCategory(String categoryName) {
        return products.values().stream()
                .filter(product -> product.getCategory().getCategoryName().equalsIgnoreCase(categoryName))
                .collect(Collectors.toList());
    }
    public List<Product<? extends ProductCategory>> findProductsByPriceRange(double minPrice, double maxPrice) {
        return products.values().stream()
                .filter(product -> product.getPrice() >= minPrice && product.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }
    public List<Product<? extends ProductCategory>> findProductsByMinRating(double minRating) {
        return products.values().stream()
                .filter(product -> product.getRating() >= minRating)
                .sorted((p1, p2) -> Double.compare(p2.getRating(), p1.getRating()))
                .collect(Collectors.toList());
    }
    public List<Product<? extends ProductCategory>> findDiscountedProducts() {
        return products.values().stream()
                .filter(product -> product.getDiscountPercentage() > 0)
                .sorted((p1, p2) -> Double.compare(p2.getDiscountPercentage(), p1.getDiscountPercentage()))
                .collect(Collectors.toList());
    }
    public List<Product<? extends ProductCategory>> findLowStockProducts(int threshold) {
        return products.values().stream()
                .filter(product -> product.isLowStock(threshold))
                .collect(Collectors.toList());
    }
    public List<Product<? extends ProductCategory>> searchProductsByName(String searchTerm) {
        return products.values().stream()
                .filter(product -> product.getName().toLowerCase().contains(searchTerm.toLowerCase()))
                .collect(Collectors.toList());
    }
    public List<Product<? extends ProductCategory>> getTopRatedProducts(int limit) {
        return products.values().stream()
                .filter(product -> product.getReviewCount() > 0)
                .sorted((p1, p2) -> Double.compare(p2.getRating(), p1.getRating()))
                .limit(limit)
                .collect(Collectors.toList());
    }
    public double calculateTotalCatalogValue() {
        return products.values().stream()
                .mapToDouble(product -> product.getPrice() * product.getStockQuantity())
                .sum();
    }
    public void displayCatalogStatistics() {
        System.out.println("\n=== CATALOG STATISTICS ===");
        System.out.println("Catalog Name: " + catalogName);
        System.out.println("Total Products: " + products.size());
        System.out.println("Total Catalog Value: $" + String.format("%.2f", calculateTotalCatalogValue()));
        Map<String, Long> categoryCount = products.values().stream()
                .collect(Collectors.groupingBy(
                        product -> product.getCategory().getCategoryName(),
                        Collectors.counting()));
        System.out.println("\nProducts by Category:");
        categoryCount.forEach((category, count) -> System.out.println("  " + category + ": " + count + " products"));
        double avgRating = products.values().stream()
                .filter(product -> product.getReviewCount() > 0)
                .mapToDouble(Product::getRating)
                .average()
                .orElse(0.0);
        System.out.println("Average Rating: " + String.format("%.1f", avgRating));
        long discountedProducts = products.values().stream()
                .filter(product -> product.getDiscountPercentage() > 0)
                .count();
        System.out.println("Products on Discount: " + discountedProducts);
    }
    public void displayAllProducts() {
        System.out.println("\n=== ALL PRODUCTS IN " + catalogName.toUpperCase() + " ===");
        if (products.isEmpty()) {
            System.out.println("No products in catalog.");
            return;
        }
        Map<String, List<Product<? extends ProductCategory>>> productsByCategory = products.values().stream()
                .collect(Collectors.groupingBy(
                        product -> product.getCategory().getCategoryName()));
        productsByCategory.forEach((category, productList) -> {
            System.out.println("\n--- " + category.toUpperCase() + " ---");
            productList.forEach(product -> System.out.println("  " + product));
        });
    }
    public String getCatalogName() {
        return catalogName;
    }
    public int getTotalProducts() {
        return products.size();
    }
    public Product<? extends ProductCategory> getProduct(String productId) {
        return products.get(productId);
    }
}