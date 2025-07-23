package warehouse;
import java.util.*;
import java.time.LocalDate;
public class WarehouseManagementSystem {
    private Map<String, Storage<? extends WarehouseItem>> storages;
    private String warehouseName;
    public WarehouseManagementSystem(String warehouseName) {
        this.warehouseName = warehouseName;
        this.storages = new HashMap<>();
    }
    public <T extends WarehouseItem> void addStorage(String storageId, Storage<T> storage) {
        storages.put(storageId, storage);
        System.out.println("Added storage: " + storageId);
    }
    public void displayAllItems() {
        System.out.println("\n=== ALL ITEMS IN " + warehouseName.toUpperCase() + " ===");
        if (storages.isEmpty()) {
            System.out.println("No storage units available.");
            return;
        }
        for (Map.Entry<String, Storage<? extends WarehouseItem>> entry : storages.entrySet()) {
            String storageId = entry.getKey();
            Storage<? extends WarehouseItem> storage = entry.getValue();
            System.out.println("\n--- Storage: " + storageId + " ---");
            System.out.println(storage.toString());
            List<? extends WarehouseItem> items = storage.getAllItems();
            if (items.isEmpty()) {
                System.out.println("  No items in this storage.");
            } else {
                for (WarehouseItem item : items) {
                    System.out.println("  " + item.toString());
                }
            }
        }
    }
    public void displayItemsByCategory(String category) {
        System.out.println("\n=== ITEMS IN CATEGORY: " + category.toUpperCase() + " ===");
        boolean found = false;
        for (Storage<? extends WarehouseItem> storage : storages.values()) {
            List<? extends WarehouseItem> items = storage.getAllItems();
            for (WarehouseItem item : items) {
                if (item.getCategory().equalsIgnoreCase(category)) {
                    System.out.println("  " + item.toString());
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("No items found in category: " + category);
        }
    }
    public double calculateTotalWarehouseValue() {
        double totalValue = 0.0;
        for (Storage<? extends WarehouseItem> storage : storages.values()) {
            List<? extends WarehouseItem> items = storage.getAllItems();
            for (WarehouseItem item : items) {
                totalValue += item.getPrice() * item.getQuantity();
            }
        }
        return totalValue;
    }
    public double calculateTotalStorageCost() {
        return storages.values().stream()
                .mapToDouble(Storage::getTotalStorageCost)
                .sum();
    }
    public <T extends WarehouseItem> List<T> findItemsByPriceRange(
            Storage<T> storage, double minPrice, double maxPrice) {
        List<T> result = new ArrayList<>();
        for (T item : storage.getAllItems()) {
            if (item.getPrice() >= minPrice && item.getPrice() <= maxPrice) {
                result.add(item);
            }
        }
        return result;
    }
    public void displayWarehouseStatistics() {
        System.out.println("\n=== WAREHOUSE STATISTICS ===");
        System.out.println("Warehouse Name: " + warehouseName);
        System.out.println("Total Storage Units: " + storages.size());
        System.out.println("Total Warehouse Value: $" + String.format("%.2f", calculateTotalWarehouseValue()));
        System.out.println("Total Storage Cost: $" + String.format("%.2f", calculateTotalStorageCost()));
        Map<String, Integer> categoryCount = new HashMap<>();
        for (Storage<? extends WarehouseItem> storage : storages.values()) {
            for (WarehouseItem item : storage.getAllItems()) {
                categoryCount.merge(item.getCategory(), item.getQuantity(), Integer::sum);
            }
        }
        System.out.println("\nItems by Category:");
        categoryCount.forEach((category, count) -> System.out.println("  " + category + ": " + count + " items"));
    }
    public static void main(String[] args) {
        WarehouseManagementSystem warehouse = new WarehouseManagementSystem("Smart Warehouse Alpha");
        Storage<Electronics> electronicsStorage = new Storage<>("ELEC-001", 50, "Climate Controlled");
        Storage<Groceries> groceriesStorage = new Storage<>("GROC-001", 100, "Temperature Controlled");
        Storage<Furniture> furnitureStorage = new Storage<>("FURN-001", 30, "Large Item Storage");
        warehouse.addStorage("ELEC-001", electronicsStorage);
        warehouse.addStorage("GROC-001", groceriesStorage);
        warehouse.addStorage("FURN-001", furnitureStorage);
        Electronics laptop = new Electronics("E001", "Gaming Laptop", 1500.0, 10, "A1-B2",
                "ASUS", 24, true);
        Electronics smartphone = new Electronics("E002", "Smartphone", 800.0, 25, "A1-B3",
                "Samsung", 12, true);
        Electronics headphones = new Electronics("E003", "Wireless Headphones", 200.0, 50, "A1-B4",
                "Sony", 6, false);
        electronicsStorage.addItem(laptop);
        electronicsStorage.addItem(smartphone);
        electronicsStorage.addItem(headphones);
        Groceries milk = new Groceries("G001", "Organic Milk", 3.50, 100, "B2-C1",
                LocalDate.now().plusDays(7), true, "refrigerated");
        Groceries rice = new Groceries("G002", "Basmati Rice", 12.99, 200, "B2-C2",
                LocalDate.now().plusMonths(12), false, "dry");
        Groceries iceCream = new Groceries("G003", "Premium Ice Cream", 8.99, 30, "B2-C3",
                LocalDate.now().plusMonths(6), true, "frozen");
        groceriesStorage.addItem(milk);
        groceriesStorage.addItem(rice);
        groceriesStorage.addItem(iceCream);
        Furniture sofa = new Furniture("F001", "3-Seater Sofa", 899.99, 5, "C3-D1",
                "Leather", 85.5, "200x90x85", true);
        Furniture table = new Furniture("F002", "Dining Table", 450.0, 8, "C3-D2",
                "Oak Wood", 45.0, "150x90x75", true);
        Furniture chair = new Furniture("F003", "Office Chair", 299.99, 15, "C3-D3",
                "Mesh", 12.5, "60x60x110", false);
        furnitureStorage.addItem(sofa);
        furnitureStorage.addItem(table);
        furnitureStorage.addItem(chair);
        System.out.println("=== SMART WAREHOUSE MANAGEMENT SYSTEM DEMO ===");
        warehouse.displayAllItems();
        warehouse.displayItemsByCategory("Electronics");
        warehouse.displayItemsByCategory("Groceries");
        warehouse.displayWarehouseStatistics();
        System.out.println("\n=== ELECTRONICS IN PRICE RANGE $100-$500 ===");
        List<Electronics> affordableElectronics = warehouse.findItemsByPriceRange(
                electronicsStorage, 100.0, 500.0);
        affordableElectronics.forEach(System.out::println);
        System.out.println("\n=== LOW STOCK ITEMS (< 20) ===");
        electronicsStorage.getLowStockItems(20).forEach(item -> System.out.println("LOW STOCK: " + item.toString()));
        furnitureStorage.getLowStockItems(20).forEach(item -> System.out.println("LOW STOCK: " + item.toString()));
    }
}