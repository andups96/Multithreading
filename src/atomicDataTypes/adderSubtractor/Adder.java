package atomicDataTypes.adderSubtractor;

public class Adder implements Runnable {
    private final Count count;

    public Adder(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
//            count.value++;
            count.value.addAndGet(i);
        }

    }
}
