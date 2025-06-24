public class Q7_Product {
    private String productName;
    private double price;
    private static int totalProducts = 0;

    public Q7_Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }

    public void displayProductDetails() {
        System.out.println("Product Details:");
        System.out.println("Name: " + productName);
        System.out.println("Price: $" + price);
    }

    public static void displayTotalProducts() {
        System.out.println("Total Products in Inventory: " + totalProducts);
    }

    public static void main(String[] args) {
        System.out.println("Initial inventory status:");
        Q7_Product.displayTotalProducts();

        Q7_Product product1 = new Q7_Product("Laptop", 999.99);
        Q7_Product product2 = new Q7_Product("Smartphone", 499.99);
        Q7_Product product3 = new Q7_Product("Headphones", 79.99);

        System.out.println("\nProduct Information:");
        product1.displayProductDetails();
        System.out.println();
        product2.displayProductDetails();
        System.out.println();
        product3.displayProductDetails();

        System.out.println("\nFinal inventory status:");
        Q7_Product.displayTotalProducts();
    }
}
