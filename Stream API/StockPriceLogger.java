import java.util.*;

public class StockPriceLogger {
    public static void main(String[] args) {
        List<Double> prices = Arrays.asList(101.5, 102.3, 100.8, 103.2);
        prices.forEach(System.out::println);
    }
}
