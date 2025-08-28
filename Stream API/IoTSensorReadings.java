import java.util.*;

public class IoTSensorReadings {
    public static void main(String[] args) {
        List<Integer> readings = Arrays.asList(45, 60, 72, 55, 80);
        int threshold = 60;
        readings.stream()
                .filter(r -> r > threshold)
                .forEach(System.out::println);
    }
}
