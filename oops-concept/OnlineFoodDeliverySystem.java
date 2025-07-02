abstract class FoodItem {
    protected String itemName;
    protected double price;
    protected int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice();

    public String getItemDetails() {
        return "Item: " + itemName + ", Price: $" + price + ", Quantity: " + quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

interface Discountable {
    double applyDiscount();

    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return price * quantity;
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.1;
    }

    @Override
    public String getDiscountDetails() {
        return "Vegetarian Discount: 10%";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (price * quantity) + (price * quantity * 0.15);
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05;
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Vegetarian Discount: 5%";
    }
}

public class OnlineFoodDeliverySystem {
    public static void processOrder(FoodItem[] items) {
        double totalOrderValue = 0;
        double totalDiscount = 0;

        for (FoodItem item : items) {
            double itemTotal = item.calculateTotalPrice();
            double itemDiscount = 0;

            System.out.println(item.getItemDetails());
            System.out.println("Item Total: $" + itemTotal);

            if (item instanceof Discountable) {
                itemDiscount = ((Discountable) item).applyDiscount();
                System.out.println(((Discountable) item).getDiscountDetails());
                System.out.println("Discount: $" + itemDiscount);
            }

            double finalItemPrice = itemTotal - itemDiscount;
            System.out.println("Final Item Price: $" + finalItemPrice);
            System.out.println("------------------------");

            totalOrderValue += finalItemPrice;
            totalDiscount += itemDiscount;
        }

        System.out.println("Order Summary:");
        System.out.println("Total Order Value: $" + totalOrderValue);
        System.out.println("Total Discount: $" + totalDiscount);
    }

    public static void main(String[] args) {
        FoodItem[] orderItems = {
                new VegItem("Veg Pizza", 12.0, 2),
                new NonVegItem("Chicken Burger", 8.0, 3),
                new VegItem("Pasta", 10.0, 1),
                new NonVegItem("Fish Curry", 15.0, 2)
        };

        processOrder(orderItems);
    }
}
