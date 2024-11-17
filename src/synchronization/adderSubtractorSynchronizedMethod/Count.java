package synchronization.adderSubtractorSynchronizedMethod;

public class Count {
    private int value = 0;

    public synchronized void incrementValue(int i){
        this.value += i;
    }

    public int getValue(){
        return this.value;
    }
}
