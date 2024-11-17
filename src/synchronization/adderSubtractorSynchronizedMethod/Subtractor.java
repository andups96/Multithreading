package synchronization.adderSubtractorSynchronizedMethod;

public class Subtractor implements Runnable {
    private final Count count;

    public Subtractor(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            count.incrementValue(-i);
        }
    }
}