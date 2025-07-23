package marketplace;
public class BookCategory implements ProductCategory {
    @Override
    public String getCategoryName() {
        return "Books";
    }
    @Override
    public double getMinPrice() {
        return 5.0;
    }
    @Override
    public double getMaxPrice() {
        return 200.0;
    }
    @Override
    public String[] getAllowedAttributes() {
        return new String[] { "author", "genre", "publisher", "isbn", "pages", "language" };
    }
}