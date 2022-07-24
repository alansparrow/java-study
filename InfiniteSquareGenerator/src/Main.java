import java.util.PrimitiveIterator;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        IntStream squares = IntStream.generate(new SquareGenerator());
        PrimitiveIterator.OfInt stepThrough = squares.iterator();

        for (int i = 0; i < 10; i++) {
            System.out.println(stepThrough.nextInt());
        }
        System.out.println("First iteration done...");

        // We can go on as long as we like..
        for (int i = 0; i < 10; i++) {
            System.out.println(stepThrough.nextInt());
        }
    }
}
