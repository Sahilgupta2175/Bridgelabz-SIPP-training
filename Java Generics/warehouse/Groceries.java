package warehouse;
import java.time.LocalDate;
public class Groceries extends WarehouseItem {
    private LocalDate expiryDate;
    private boolean isPerishable;
    private String storageType;
    public Groceries(String itemId, String itemName, double price, int quantity,
            String location, LocalDate expiryDate, boolean isPerishable, String storageType) {
        super(itemId, itemName, price, quantity, location);
        this.expiryDate = expiryDate;
        this.isPerishable = isPerishable;
        this.storageType = storageType;
    }
    @Override
    public String getCategory() {
        return "Groceries";
    }
    @Override
    public double calculateStorageCost() {
        double baseCost = getPrice() * 0.03;
        switch (storageType.toLowerCase()) {
            case "frozen":
                baseCost *= 2.0;
                break;
            case "refrigerated":
                baseCost *= 1.5;
                break;
            case "dry":
                baseCost *= 1.0;
                break;
        }
        if (isPerishable) {
            baseCost *= 1.3;
        }
        return baseCost * getQuantity();
    }
    public boolean isExpiringSoon() {
        return expiryDate.isBefore(LocalDate.now().plusDays(7));
    }
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
    public boolean isPerishable() {
        return isPerishable;
    }
    public void setPerishable(boolean perishable) {
        isPerishable = perishable;
    }
    public String getStorageType() {
        return storageType;
    }
    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }
    @Override
    public String toString() {
        return super.toString()
                + String.format(" [Expiry: %s, Perishable: %s, Storage: %s, Storage Cost: %.2f, Expiring Soon: %s]",
                        expiryDate, isPerishable, storageType, calculateStorageCost(), isExpiringSoon());
    }
}