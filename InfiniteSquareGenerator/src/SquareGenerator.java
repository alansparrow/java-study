import java.util.function.IntSupplier;

public class SquareGenerator implements IntSupplier {
    private int current = 1;

    @Override
    public synchronized int getAsInt() {
        int res = current * current;
        current++;
        return res;
    }
}
