import java.util.*;
import java.util.stream.Collectors;

public class OrderRevenueSummary {
    static class Order {
        String customer;
        double total;

        Order(String customer, double total) {
            this.customer = customer;
            this.total = total;
        }

        public String getCustomer() {
            return customer;
        }

        public double getTotal() {
            return total;
        }
    }

    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("Alice", 120.0),
                new Order("Bob", 80.0),
                new Order("Alice", 30.0),
                new Order("Bob", 20.0),
                new Order("Charlie", 50.0));
        Map<String, Double> revenue = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCustomer,
                        Collectors.summingDouble(Order::getTotal)));
        System.out.println(revenue);
    }
}
