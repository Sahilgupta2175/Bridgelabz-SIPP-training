package systems;

import java.util.*;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Product{name='%s', price=%.2f}", name, price);
    }
}

public class ShoppingCart {
    private HashMap<String, Double> productPrices;
    private LinkedHashMap<String, Integer> cartItems;
    private TreeMap<Double, List<String>> itemsByPrice;

    public ShoppingCart() {
        productPrices = new HashMap<>();
        cartItems = new LinkedHashMap<>();
        itemsByPrice = new TreeMap<>();
    }

    public void addProduct(String productName, double price) {
        productPrices.put(productName, price);
    }

    public void addToCart(String productName, int quantity) {
        if (!productPrices.containsKey(productName)) {
            System.out.println("Product not found: " + productName);
            return;
        }

        cartItems.put(productName, cartItems.getOrDefault(productName, 0) + quantity);

        double price = productPrices.get(productName);
        itemsByPrice.putIfAbsent(price, new ArrayList<>());
        if (!itemsByPrice.get(price).contains(productName)) {
            itemsByPrice.get(price).add(productName);
        }
    }

    public void displayCartInAddOrder() {
        System.out.println("Cart items in order added:");
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            String product = entry.getKey();
            int quantity = entry.getValue();
            double price = productPrices.get(product);
            System.out.printf("%s: %d x $%.2f = $%.2f%n",
                    product, quantity, price, quantity * price);
        }
    }

    public void displayCartSortedByPrice() {
        System.out.println("Cart items sorted by price:");
        for (Map.Entry<Double, List<String>> entry : itemsByPrice.entrySet()) {
            double price = entry.getKey();
            for (String product : entry.getValue()) {
                if (cartItems.containsKey(product)) {
                    int quantity = cartItems.get(product);
                    System.out.printf("%s: %d x $%.2f = $%.2f%n",
                            product, quantity, price, quantity * price);
                }
            }
        }
    }

    public double getTotalCost() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            String product = entry.getKey();
            int quantity = entry.getValue();
            double price = productPrices.get(product);
            total += quantity * price;
        }
        return total;
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Laptop", 999.99);
        cart.addProduct("Mouse", 29.99);
        cart.addProduct("Keyboard", 79.99);
        cart.addProduct("Monitor", 199.99);

        cart.addToCart("Laptop", 1);
        cart.addToCart("Mouse", 2);
        cart.addToCart("Keyboard", 1);
        cart.addToCart("Monitor", 1);

        cart.displayCartInAddOrder();
        System.out.println();

        cart.displayCartSortedByPrice();
        System.out.println();

        System.out.printf("Total cost: $%.2f%n", cart.getTotalCost());
    }
}
