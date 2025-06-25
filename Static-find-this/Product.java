/**
 * Product class for Shopping Cart System
 * Demonstrates static variables, static methods, this keyword, final variables,
 * and instanceof
 */
public class Product {
    // Static variable shared by all products - represents discount percentage
    private static double discount = 10.0; // Default 10% discount

    // Static variable to track total number of products created
    private static int totalProducts = 0;

    // Instance variables
    private String productName;
    private double price;
    private int quantity;

    // Final variable - product ID cannot be changed once assigned
    private final String productID;

    private String category;
    private boolean inStock;

    /**
     * Constructor to create a new product
     * Uses 'this' keyword to initialize instance variables when parameter names
     * match
     * 
     * @param productName Name of the product
     * @param price       Price per unit of the product
     * @param quantity    Available quantity in stock
     * @param productID   Unique product identifier (final - cannot be changed)
     * @param category    Category/type of the product
     */
    public Product(String productName, double price, int quantity, String productID, String category) {
        // Using 'this' to distinguish between instance variables and parameters
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.category = category;

        // Final variable assignment - can only be done once during initialization
        this.productID = productID;

        // Set stock status based on quantity
        this.inStock = quantity > 0;

        // Increment static counter for total products
        totalProducts++;
    }

    /**
     * Static method to update the discount percentage for all products
     * Can be called without creating an instance of the Product class
     * 
     * @param newDiscount New discount percentage to be applied
     */
    public static void updateDiscount(double newDiscount) {
        if (newDiscount >= 0 && newDiscount <= 100) {
            discount = newDiscount;
            System.out.println("Discount updated to: " + discount + "%");
        } else {
            System.out.println("Invalid discount percentage! Must be between 0 and 100.");
        }
    }

    /**
     * Static method to get current discount percentage
     * 
     * @return Current discount percentage
     */
    public static double getDiscount() {
        return discount;
    }

    /**
     * Static method to get total number of products
     * 
     * @return Total count of products created
     */
    public static int getTotalProducts() {
        return totalProducts;
    }

    /**
     * Static method to display current discount information
     */
    public static void displayDiscountInfo() {
        System.out.println("Current store-wide discount: " + discount + "%");
    }

    /**
     * Method to calculate discounted price for this product
     * 
     * @return Price after applying current discount
     */
    public double getDiscountedPrice() {
        return this.price * (1 - discount / 100);
    }

    /**
     * Method to calculate total cost for a given quantity
     * 
     * @param purchaseQuantity Number of units to purchase
     * @return Total cost after discount
     */
    public double calculateTotalCost(int purchaseQuantity) {
        if (purchaseQuantity <= 0) {
            System.out.println("Invalid purchase quantity!");
            return 0;
        }

        if (purchaseQuantity > this.quantity) {
            System.out.println("Insufficient stock! Available: " + this.quantity);
            return 0;
        }

        double totalCost = purchaseQuantity * getDiscountedPrice();
        return totalCost;
    }

    /**
     * Method to process a purchase (reduce stock)
     * 
     * @param purchaseQuantity Number of units being purchased
     * @return true if purchase successful, false otherwise
     */
    public boolean processPurchase(int purchaseQuantity) {
        if (purchaseQuantity <= 0) {
            System.out.println("Invalid purchase quantity!");
            return false;
        }

        if (purchaseQuantity > this.quantity) {
            System.out.println("Insufficient stock for " + this.productName);
            return false;
        }

        this.quantity -= purchaseQuantity;
        this.inStock = this.quantity > 0;

        double totalCost = calculateTotalCost(purchaseQuantity);
        System.out.println("Purchase successful!");
        System.out.println("Product: " + this.productName);
        System.out.println("Quantity purchased: " + purchaseQuantity);
        System.out.println("Total cost: $" + String.format("%.2f", totalCost));
        System.out.println("Remaining stock: " + this.quantity);

        return true;
    }

    /**
     * Method to restock the product
     * 
     * @param additionalQuantity Quantity to add to current stock
     */
    public void restock(int additionalQuantity) {
        if (additionalQuantity > 0) {
            this.quantity += additionalQuantity;
            this.inStock = true;
            System.out.println("Restocked " + additionalQuantity + " units of " + this.productName);
            System.out.println("New stock level: " + this.quantity);
        } else {
            System.out.println("Invalid restock quantity!");
        }
    }

    /**
     * Method to display detailed product information
     * This method is called only after instanceof verification
     */
    public void displayProductDetails() {
        System.out.println("\n=== Product Details ===");
        System.out.println("Product ID: " + this.productID);
        System.out.println("Name: " + this.productName);
        System.out.println("Category: " + this.category);
        System.out.println("Original Price: $" + String.format("%.2f", this.price));
        System.out.println("Discounted Price: $" + String.format("%.2f", getDiscountedPrice()));
        System.out.println("Current Discount: " + discount + "%");
        System.out.println("Available Quantity: " + this.quantity);
        System.out.println("In Stock: " + (this.inStock ? "Yes" : "No"));
        System.out.println("=======================");
    }

    /**
     * Static method to safely process product details using instanceof
     * Demonstrates type checking before casting and method invocation
     * 
     * @param obj Object to be verified and processed
     */
    public static void displayProductInfo(Object obj) {
        // Using instanceof to validate whether an object is an instance of the Product
        // class
        if (obj instanceof Product) {
            System.out.println("Valid Product object detected!");
            Product product = (Product) obj; // Safe casting after instanceof check
            product.displayProductDetails();
        } else {
            System.out.println("Error: Object is not an instance of Product class!");
            System.out.println("Cannot process product details for: " + obj.getClass().getSimpleName());
        }
    }

    /**
     * Method to check if product is available in required quantity
     * 
     * @param requiredQuantity Quantity needed
     * @return true if available, false otherwise
     */
    public boolean isAvailable(int requiredQuantity) {
        return this.inStock && this.quantity >= requiredQuantity;
    }

    /**
     * Getter methods for accessing private fields
     */
    public String getProductName() {
        return this.productName;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getProductID() {
        return this.productID; // Final variable - read-only access
    }

    public String getCategory() {
        return this.category;
    }

    public boolean isInStock() {
        return this.inStock;
    }

    /**
     * Setter methods (excluding final variable 'productID')
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("Invalid price!");
        }
    }

    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Main method to demonstrate the Product class functionality
     */
    public static void main(String[] args) {
        System.out.println("=== Shopping Cart System Demo ===\n");

        // Display initial discount information
        Product.displayDiscountInfo();
        System.out.println("Initial products count: " + Product.getTotalProducts());

        // Create product instances
        Product product1 = new Product("Laptop", 1200.00, 15, "PROD001", "Electronics");
        Product product2 = new Product("Smartphone", 800.00, 25, "PROD002", "Electronics");
        Product product3 = new Product("Coffee Maker", 150.00, 10, "PROD003", "Appliances");
        Product product4 = new Product("Wireless Headphones", 200.00, 30, "PROD004", "Electronics");
        Product product5 = new Product("Office Chair", 350.00, 8, "PROD005", "Furniture");

        // Display updated product count
        System.out.println("\nAfter adding products:");
        System.out.println("Total products in catalog: " + Product.getTotalProducts());

        // Demonstrate product operations
        System.out.println("\n=== Product Operations ===");

        // Show original prices and discounted prices
        System.out.println("Price comparison for " + product1.getProductName() + ":");
        System.out.println("Original Price: $" + String.format("%.2f", product1.getPrice()));
        System.out.println("Discounted Price: $" + String.format("%.2f", product1.getDiscountedPrice()));

        // Process some purchases
        product1.processPurchase(2);
        product2.processPurchase(5);
        product3.processPurchase(15); // This should fail due to insufficient stock

        // Restock a product
        product3.restock(5);
        product3.processPurchase(3); // This should now succeed

        // Demonstrate instanceof usage with valid Product objects
        System.out.println("\n=== Instanceof Demonstration ===");
        Product.displayProductInfo(product1);
        Product.displayProductInfo(product2);
        Product.displayProductInfo(product3);
        Product.displayProductInfo(product4);
        Product.displayProductInfo(product5);

        // Demonstrate instanceof with invalid objects
        String invalidObject1 = "Not a Product";
        Integer invalidObject2 = 42;
        Product.displayProductInfo(invalidObject1);
        Product.displayProductInfo(invalidObject2);

        // Demonstrate discount update
        System.out.println("\n=== Discount Update Demo ===");
        Product.updateDiscount(20.0); // Increase discount to 20%
        Product.displayDiscountInfo();

        // Show updated prices after discount change
        System.out.println("\nUpdated prices after discount change:");
        Product[] allProducts = { product1, product2, product3, product4, product5 };
        for (Product product : allProducts) {
            System.out.println(product.getProductName() + " - New discounted price: $" +
                    String.format("%.2f", product.getDiscountedPrice()));
        }

        // Final variable demonstration
        System.out.println("\n=== Final Variable Demo ===");
        System.out.println("Product ID (final variable): " + product1.getProductID());
        // product1.productID = "NEW_PROD001"; // Uncommenting this would cause
        // compilation error

        // Shopping cart simulation
        System.out.println("\n=== Shopping Cart Simulation ===");
        double totalCartValue = 0;

        // Simulate adding products to cart
        int[][] cartItems = {
                { 1, 1 }, // 1 Laptop
                { 2, 2 }, // 2 Smartphones
                { 4, 1 } // 1 Wireless Headphones
        };

        System.out.println("Items in cart:");
        for (int[] item : cartItems) {
            int productIndex = item[0] - 1; // Convert to array index
            int purchaseQuantity = item[1];

            if (productIndex < allProducts.length) {
                Product product = allProducts[productIndex];
                if (product.isAvailable(purchaseQuantity)) {
                    double itemCost = product.calculateTotalCost(purchaseQuantity);
                    totalCartValue += itemCost;
                    System.out.println("- " + product.getProductName() + " x" + purchaseQuantity +
                            " = $" + String.format("%.2f", itemCost));
                }
            }
        }

        System.out.println("Total cart value: $" + String.format("%.2f", totalCartValue));
        System.out.println("Discount applied: " + Product.getDiscount() + "%");

        // Final statistics
        System.out.println("\n=== Final Statistics ===");
        System.out.println("Total products in catalog: " + Product.getTotalProducts());
        Product.displayDiscountInfo();

        // Display stock levels
        System.out.println("\nCurrent stock levels:");
        for (Product product : allProducts) {
            System.out.println("- " + product.getProductName() + ": " + product.getQuantity() + " units");
        }
    }
}
