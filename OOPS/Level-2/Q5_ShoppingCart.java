import java.util.ArrayList;
import java.util.Iterator;

public class Q5_ShoppingCart {

    static class CartItem {
        String itemName;
        double price;
        int quantity;

        public CartItem(String itemName, double price, int quantity) {
            this.itemName = itemName;
            this.price = price;
            this.quantity = quantity;
        }

        public double getTotalPrice() {
            return price * quantity;
        }

        public void displayItem() {
            System.out.println(itemName + " x " + quantity + " = ₹" + getTotalPrice());
        }
    }

    static class ShoppingCart {
        ArrayList<CartItem> items = new ArrayList<>();

        public void addItem(CartItem item) {
            items.add(item);
            System.out.println(item.itemName + " added to cart.");
        }

        public void removeItem(String itemName) {
            Iterator<CartItem> it = items.iterator();
            while (it.hasNext()) {
                if (it.next().itemName.equalsIgnoreCase(itemName)) {
                    it.remove();
                    System.out.println(itemName + " removed from cart.");
                    return;
                }
            }
            System.out.println(itemName + " not found in cart.");
        }

        public void displayTotal() {
            double total = 0;
            System.out.println("\n--- Cart Summary ---");
            for (CartItem item : items) {
                item.displayItem();
                total += item.getTotalPrice();
            }
            System.out.println("Total Amount: ₹" + total);
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new CartItem("Laptop", 50000, 1));
        cart.addItem(new CartItem("Mouse", 700, 2));
        cart.removeItem("Keyboard"); // not found
        cart.displayTotal();
    }
}
