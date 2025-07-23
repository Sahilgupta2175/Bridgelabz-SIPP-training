package warehouse;
import java.util.*;
import java.util.stream.Collectors;
public class Storage<T extends WarehouseItem> {
    private List<T> items;
    private String storageId;
    private int maxCapacity;
    private String storageType;
    public Storage(String storageId, int maxCapacity, String storageType) {
        this.storageId = storageId;
        this.maxCapacity = maxCapacity;
        this.storageType = storageType;
        this.items = new ArrayList<>();
    }
    public boolean addItem(T item) {
        if (getCurrentCapacity() >= maxCapacity) {
            System.out.println("Storage is full! Cannot add item: " + item.getItemName());
            return false;
        }
        items.add(item);
        System.out.println("Added item to storage: " + item.getItemName());
        return true;
    }
    public boolean removeItem(String itemId) {
        return items.removeIf(item -> item.getItemId().equals(itemId));
    }
    public Optional<T> getItem(String itemId) {
        return items.stream()
                .filter(item -> item.getItemId().equals(itemId))
                .findFirst();
    }
    public List<T> getAllItems() {
        return new ArrayList<>(items);
    }
    public List<T> searchItemsByName(String name) {
        return items.stream()
                .filter(item -> item.getItemName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
    public List<T> getLowStockItems(int threshold) {
        return items.stream()
                .filter(item -> item.getQuantity() < threshold)
                .collect(Collectors.toList());
    }
    public double getTotalStorageCost() {
        return items.stream()
                .mapToDouble(WarehouseItem::calculateStorageCost)
                .sum();
    }
    public int getCurrentCapacity() {
        return items.size();
    }
    public boolean isFull() {
        return getCurrentCapacity() >= maxCapacity;
    }
    public double getUtilizationPercentage() {
        return (double) getCurrentCapacity() / maxCapacity * 100;
    }
    public String getStorageId() {
        return storageId;
    }
    public int getMaxCapacity() {
        return maxCapacity;
    }
    public String getStorageType() {
        return storageType;
    }
    @Override
    public String toString() {
        return String.format("Storage[ID: %s, Type: %s, Capacity: %d/%d (%.1f%%), Items: %d, Total Cost: %.2f]",
                storageId, storageType, getCurrentCapacity(), maxCapacity,
                getUtilizationPercentage(), items.size(), getTotalStorageCost());
    }
}