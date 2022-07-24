import java.util.LinkedList;

public class WaitingQueue<E> {
//    private LinkedList<E> q = new LinkedList<>();
    private volatile LinkedList<E> q = new LinkedList<>();

    public synchronized void push(E o) {
        q.add(o);
        System.out.printf("Thread: %d '%s', push: %s\n",
                Thread.currentThread().getId(),
                Thread.currentThread().getName(),
                o);
        this.notifyAll();
    }

    public synchronized E pop() {
        while (q.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException ignored) {

            }
        }

        System.out.printf("Thread: %d '%s', pop: %s\n",
                Thread.currentThread().getId(),
                Thread.currentThread().getName(),
                q.getFirst());
        return q.remove();
    }
}

