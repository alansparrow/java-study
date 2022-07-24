public class Main {
    public static void main(String[] args) {
        WaitingQueue<String> waitingQueue = new WaitingQueue<>();
        Thread t1 = new Thread(
                () -> {
                    for (int i = 0; i < 10; i++) {
                        waitingQueue.push(String.valueOf(i));
                    }
                }
        );

        Thread t2 = new Thread(
                () -> {
                    for (int i = 0; i < 10; i++) {
                        waitingQueue.pop();
                    }
                }
        );

        t1.setName("Pusher");
        t1.start();
        t2.setName("Popper");
        t2.start();
    }
}
//This class uses a wait() on the instance of WaitingQueue if the queue is empty
//(which would make the pop() fail). The waiting thread temporarily releases its
//monitor, allowing another thread to claim it—a thread that might push() some‐
//thing new onto the queue. When the original thread is woken up again, it is restar‐
//ted where it originally began to wait—and it will have reacquired its monitor.

// out example
//Thread: 22 'Pusher', push: 0
//Thread: 23 'Popper', pop: 0
//Thread: 22 'Pusher', push: 1
//Thread: 23 'Popper', pop: 1
//Thread: 22 'Pusher', push: 2
//Thread: 22 'Pusher', push: 3
//Thread: 22 'Pusher', push: 4
//Thread: 22 'Pusher', push: 5
//Thread: 22 'Pusher', push: 6
//Thread: 22 'Pusher', push: 7
//Thread: 22 'Pusher', push: 8
//Thread: 22 'Pusher', push: 9
//Thread: 23 'Popper', pop: 2
//Thread: 23 'Popper', pop: 3
//Thread: 23 'Popper', pop: 4
//Thread: 23 'Popper', pop: 5
//Thread: 23 'Popper', pop: 6
//Thread: 23 'Popper', pop: 7
//Thread: 23 'Popper', pop: 8
//Thread: 23 'Popper', pop: 9
//
//Process finished with exit code 0

