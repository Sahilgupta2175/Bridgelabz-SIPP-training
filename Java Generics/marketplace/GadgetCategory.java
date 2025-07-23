package marketplace;
public class GadgetCategory implements ProductCategory {
    @Override
    public String getCategoryName() {
        return "Gadgets";
    }
    @Override
    public double getMinPrice() {
        return 20.0;
    }
    @Override
    public double getMaxPrice() {
        return 5000.0;
    }
    @Override
    public String[] getAllowedAttributes() {
        return new String[] { "brand", "model", "specifications", "warranty", "connectivity", "battery" };
    }
}