package marketplace;
public class ClothingCategory implements ProductCategory {
    @Override
    public String getCategoryName() {
        return "Clothing";
    }
    @Override
    public double getMinPrice() {
        return 10.0;
    }
    @Override
    public double getMaxPrice() {
        return 1000.0;
    }
    @Override
    public String[] getAllowedAttributes() {
        return new String[] { "size", "color", "material", "brand", "gender", "season" };
    }
}