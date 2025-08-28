import java.util.*;

class Product {
    private String name;
    private double price;
    private double rating;
    private double discount;

    public Product(String name, double price, double rating, double discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public double getDiscount() {
        return discount;
    }

    public String toString() {
        return name + " | Price: " + price + ", Rating: " + rating + ", Discount: " + discount;
    }
}

public class CustomSorting {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", 1000, 4.5, 10),
                new Product("Phone", 500, 4.7, 15),
                new Product("Tablet", 300, 4.2, 20));

        // Sort by price
        products.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        System.out.println("Sorted by price: " + products);

        // Sort by rating
        products.sort((p1, p2) -> Double.compare(p2.getRating(), p1.getRating()));
        System.out.println("Sorted by rating: " + products);

        // Sort by discount
        products.sort((p1, p2) -> Double.compare(p2.getDiscount(), p1.getDiscount()));
        System.out.println("Sorted by discount: " + products);
    }
}
