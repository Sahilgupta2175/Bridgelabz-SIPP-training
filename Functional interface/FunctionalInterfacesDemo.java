import java.util.function.Predicate;
import java.util.function.Function;

public class FunctionalInterfacesDemo {
    public static void main(String[] args) {
        // Temperature Alert System
        Predicate<Double> tempAlert = temp -> temp > 40.0;
        System.out.println("Temperature Alert: " + tempAlert.test(45.0));

        // String Length Checker
        Function<String, Integer> lengthChecker = str -> str.length();
        System.out.println("Length: " + lengthChecker.apply("Hello World!"));

        // Background Job Execution
        Runnable job = () -> System.out.println("Background job running...");
        new Thread(job).start();
    }
}
