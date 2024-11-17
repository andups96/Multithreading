package synchronization.adderSubtractorMutex;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {
    private final Count count;
    private final Lock lock;

    public Adder(Count count, Lock lock) {
        this.count = count;
        this.lock = lock;
    }

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++) {
            lock.lock();
            count.value++;
            lock.unlock();
        }
    }
}
