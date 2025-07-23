package marketplace;
public interface ProductCategory {
    String getCategoryName();
    double getMinPrice();
    double getMaxPrice();
    String[] getAllowedAttributes();
}