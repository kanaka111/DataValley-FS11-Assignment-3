class Counter {
    private int c = 0;

    public synchronized void increment() {
        c++;
    }

    public synchronized int getCount() {
        return c;
    }
}

class Worker extends Thread {
    private Counter count;

    public Worker(Counter count) {
        this.count = count;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            count.increment();
        }
    }
}

public class Synchronization{
    public static void main(String[] args) throws InterruptedException {
        Counter count = new Counter();

        Worker thread1 = new Worker(count);
        Worker thread2 = new Worker(count);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final count: " + count.getCount());
    }
}