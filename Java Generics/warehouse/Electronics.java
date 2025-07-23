package warehouse;
public class Electronics extends WarehouseItem {
    private String brand;
    private int warrantyPeriod;
    private boolean isFragile;
    public Electronics(String itemId, String itemName, double price, int quantity,
            String location, String brand, int warrantyPeriod, boolean isFragile) {
        super(itemId, itemName, price, quantity, location);
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
        this.isFragile = isFragile;
    }
    @Override
    public String getCategory() {
        return "Electronics";
    }
    @Override
    public double calculateStorageCost() {
        double baseCost = getPrice() * 0.02;
        if (isFragile) {
            baseCost *= 1.5;
        }
        return baseCost * getQuantity();
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }
    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }
    public boolean isFragile() {
        return isFragile;
    }
    public void setFragile(boolean fragile) {
        isFragile = fragile;
    }
    @Override
    public String toString() {
        return super.toString() + String.format(" [Brand: %s, Warranty: %d months, Fragile: %s, Storage Cost: %.2f]",
                brand, warrantyPeriod, isFragile, calculateStorageCost());
    }
}