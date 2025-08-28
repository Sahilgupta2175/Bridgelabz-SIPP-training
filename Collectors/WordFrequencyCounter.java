import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String paragraph = "hello world hello java world java java";
        String[] words = paragraph.split("\\s+");
        Map<String, Integer> freq = Arrays.stream(words)
                .collect(Collectors.toMap(
                        w -> w,
                        w -> 1,
                        Integer::sum));
        System.out.println(freq);
    }
}
