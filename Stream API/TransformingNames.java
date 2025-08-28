import java.util.*;
import java.util.stream.Collectors;

public class TransformingNames {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("alice", "bob", "charlie", "diana");
        List<String> upperSorted = names.stream()
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        upperSorted.forEach(System.out::println);
    }
}
