package warehouse;
public class Furniture extends WarehouseItem {
    private String material;
    private double weight;
    private String dimensions;
    private boolean requiresAssembly;
    public Furniture(String itemId, String itemName, double price, int quantity,
            String location, String material, double weight, String dimensions, boolean requiresAssembly) {
        super(itemId, itemName, price, quantity, location);
        this.material = material;
        this.weight = weight;
        this.dimensions = dimensions;
        this.requiresAssembly = requiresAssembly;
    }
    @Override
    public String getCategory() {
        return "Furniture";
    }
    @Override
    public double calculateStorageCost() {
        double baseCost = getPrice() * 0.01;
        if (weight > 50) {
            baseCost *= 1.8;
        } else if (weight > 20) {
            baseCost *= 1.4;
        }
        if (requiresAssembly) {
            baseCost *= 1.2;
        }
        return baseCost * getQuantity();
    }
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public String getDimensions() {
        return dimensions;
    }
    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }
    public boolean isRequiresAssembly() {
        return requiresAssembly;
    }
    public void setRequiresAssembly(boolean requiresAssembly) {
        this.requiresAssembly = requiresAssembly;
    }
    @Override
    public String toString() {
        return super.toString() + String.format(
                " [Material: %s, Weight: %.2f kg, Dimensions: %s, Assembly Required: %s, Storage Cost: %.2f]",
                material, weight, dimensions, requiresAssembly, calculateStorageCost());
    }
}