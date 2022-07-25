import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String[] text = {"For Brutus is an honourable man",
                "Give me your hands if we be friends and Robin shall restore amends",
                "Misery acquaints a man with strange bedfellows"};
        List<String> quotes = Arrays.asList(text);

        // Create a temporary collection for our words
        List<String> words = quotes.stream()
                .flatMap(line -> {
                    return Stream.of(line.split(" +"));
                })
                .collect(Collectors.toList());
        long wordCount = words.size();

        // The cast to double is only needed to prevent Java from using
        // integer division
        double aveLength = ((double) words.stream()
                .map(String::length)
                .reduce(0, (x, y) -> { return x + y;})) / wordCount;
        System.out.println("Average word length: " + aveLength);
    }
}
