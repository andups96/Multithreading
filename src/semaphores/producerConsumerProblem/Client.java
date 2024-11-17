package semaphores.producerConsumerProblem;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Client {
    public static void main(String[] args) {
        Queue<Object> store = new ConcurrentLinkedDeque<>();
        Producer p1 = new Producer(store, 6, "p1");
        Producer p2 = new Producer(store, 6, "p2");
        Producer p3 = new Producer(store, 6, "p3");

        Consumer c1 = new Consumer(store, 6, "c1");
        Consumer c2 = new Consumer(store, 6, "c2");
        Consumer c3 = new Consumer(store, 6, "c3");
        Consumer c4 = new Consumer(store, 6, "c4");
        Consumer c5 = new Consumer(store, 6, "c5");
        Consumer c6 = new Consumer(store, 6, "c6");

        Thread thread1 = new Thread(p1);
        thread1.start();
        Thread thread2 = new Thread(p2);
        thread2.start();
        Thread thread3 = new Thread(p3);
        thread3.start();

        Thread thread4 = new Thread(c1);
        thread4.start();
        Thread thread5 = new Thread(c2);
        thread5.start();
        Thread thread6 = new Thread(c3);
        thread6.start();
        Thread thread7 = new Thread(c4);
        thread7.start();
        Thread thread8 = new Thread(c5);
        thread8.start();
        Thread thread9 = new Thread(c6);
        thread9.start();


    }
}
