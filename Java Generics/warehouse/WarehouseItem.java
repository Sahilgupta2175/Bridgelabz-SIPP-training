package warehouse;
public abstract class WarehouseItem {
    private String itemId;
    private String itemName;
    private double price;
    private int quantity;
    private String location;
    public WarehouseItem(String itemId, String itemName, double price, int quantity, String location) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.location = location;
    }
    public String getItemId() {
        return itemId;
    }
    public void setItemId(String itemId) {
        this.itemId = itemId;
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
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public abstract String getCategory();
    public abstract double calculateStorageCost();
    @Override
    public String toString() {
        return String.format("%s[ID: %s, Name: %s, Price: %.2f, Quantity: %d, Location: %s, Category: %s]",
                getClass().getSimpleName(), itemId, itemName, price, quantity, location, getCategory());
    }
}