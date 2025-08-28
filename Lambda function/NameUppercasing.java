import java.util.*;
import java.util.stream.*;

public class NameUppercasing {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("alice", "bob", "carol");
        List<String> upperNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(upperNames);
    }
}
