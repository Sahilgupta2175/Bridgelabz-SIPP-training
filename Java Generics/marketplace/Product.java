package marketplace;
import java.util.*;
import java.time.LocalDateTime;
public class Product<T extends ProductCategory> {
    private String productId;
    private String name;
    private String description;
    private double price;
    private double originalPrice;
    private int stockQuantity;
    private T category;
    private Map<String, String> attributes;
    private LocalDateTime createdAt;
    private double rating;
    private int reviewCount;
    private String sellerId;
    public Product(String productId, String name, String description, double price,
            int stockQuantity, T category, String sellerId) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.originalPrice = price;
        this.stockQuantity = stockQuantity;
        this.category = category;
        this.sellerId = sellerId;
        this.attributes = new HashMap<>();
        this.createdAt = LocalDateTime.now();
        this.rating = 0.0;
        this.reviewCount = 0;
        validatePrice();
    }
    private void validatePrice() {
        if (price < category.getMinPrice() || price > category.getMaxPrice()) {
            throw new IllegalArgumentException(
                    String.format("Price %.2f is outside valid range [%.2f - %.2f] for category %s",
                            price, category.getMinPrice(), category.getMaxPrice(), category.getCategoryName()));
        }
    }
    public void addAttribute(String key, String value) {
        String[] allowedAttributes = category.getAllowedAttributes();
        boolean isAllowed = Arrays.asList(allowedAttributes).contains(key.toLowerCase());
        if (!isAllowed) {
            throw new IllegalArgumentException(
                    String.format("Attribute '%s' is not allowed for category %s. Allowed: %s",
                            key, category.getCategoryName(), Arrays.toString(allowedAttributes)));
        }
        attributes.put(key, value);
    }
    public void setPrice(double newPrice) {
        double oldPrice = this.price;
        this.price = newPrice;
        try {
            validatePrice();
            System.out.println(String.format("Price updated for %s: %.2f -> %.2f", name, oldPrice, newPrice));
        } catch (IllegalArgumentException e) {
            this.price = oldPrice; 
            throw e;
        }
    }
    public void applyDiscount(double discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100");
        }
        double discountAmount = originalPrice * (discountPercentage / 100);
        double newPrice = originalPrice - discountAmount;
        setPrice(newPrice);
        System.out.println(String.format("Applied %.1f%% discount to %s. Price: %.2f -> %.2f (Saved: %.2f)",
                discountPercentage, name, originalPrice, newPrice, discountAmount));
    }
    public void addReview(double newRating) {
        if (newRating < 1.0 || newRating > 5.0) {
            throw new IllegalArgumentException("Rating must be between 1.0 and 5.0");
        }
        double totalRating = rating * reviewCount + newRating;
        reviewCount++;
        rating = totalRating / reviewCount;
    }
    public boolean isInStock() {
        return stockQuantity > 0;
    }
    public boolean isLowStock(int threshold) {
        return stockQuantity > 0 && stockQuantity <= threshold;
    }
    public String getProductId() {
        return productId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrice() {
        return price;
    }
    public double getOriginalPrice() {
        return originalPrice;
    }
    public int getStockQuantity() {
        return stockQuantity;
    }
    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
    public T getCategory() {
        return category;
    }
    public Map<String, String> getAttributes() {
        return new HashMap<>(attributes);
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public double getRating() {
        return rating;
    }
    public int getReviewCount() {
        return reviewCount;
    }
    public String getSellerId() {
        return sellerId;
    }
    public double getDiscountPercentage() {
        if (originalPrice == 0)
            return 0;
        return ((originalPrice - price) / originalPrice) * 100;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Product[ID: %s, Name: %s, Category: %s, Price: $%.2f",
                productId, name, category.getCategoryName(), price));
        if (getDiscountPercentage() > 0) {
            sb.append(String.format(" (%.1f%% off from $%.2f)", getDiscountPercentage(), originalPrice));
        }
        sb.append(String.format(", Stock: %d, Rating: %.1f (%d reviews), Seller: %s",
                stockQuantity, rating, reviewCount, sellerId));
        if (!attributes.isEmpty()) {
            sb.append(", Attributes: ").append(attributes);
        }
        sb.append("]");
        return sb.toString();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Product<?> product = (Product<?>) obj;
        return Objects.equals(productId, product.productId);
    }
    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }
}