abstract class Product {
    protected String productId;
    protected String name;
    protected double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public abstract double calculateDiscount();

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

interface Taxable {
    double calculateTax();

    String getTaxDetails();
}

class Electronics extends Product implements Taxable {
    public Electronics(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return price * 0.15;
    }

    @Override
    public double calculateTax() {
        return price * 0.18;
    }

    @Override
    public String getTaxDetails() {
        return "GST: 18%";
    }
}

class Clothing extends Product implements Taxable {
    public Clothing(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return price * 0.25;
    }

    @Override
    public double calculateTax() {
        return price * 0.12;
    }

    @Override
    public String getTaxDetails() {
        return "GST: 12%";
    }
}

class Groceries extends Product {
    public Groceries(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return price * 0.05;
    }
}

public class ECommercePlatform {
    public static void calculateFinalPrice(Product[] products) {
        for (Product product : products) {
            double finalPrice = product.getPrice();
            double discount = product.calculateDiscount();
            double tax = 0;

            if (product instanceof Taxable) {
                tax = ((Taxable) product).calculateTax();
                System.out.println(((Taxable) product).getTaxDetails());
            }

            finalPrice = finalPrice + tax - discount;
            System.out.println("Product: " + product.getName());
            System.out.println("Base Price: $" + product.getPrice());
            System.out.println("Discount: $" + discount);
            System.out.println("Tax: $" + tax);
            System.out.println("Final Price: $" + finalPrice);
            System.out.println("------------------------");
        }
    }

    public static void main(String[] args) {
        Product[] products = {
                new Electronics("E001", "Laptop", 1000),
                new Clothing("C001", "T-Shirt", 50),
                new Groceries("G001", "Rice", 20)
        };

        calculateFinalPrice(products);
    }
}
