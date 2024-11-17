package semaphores.producerConsumer;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {
        Queue<Object> store = new ConcurrentLinkedDeque<>();

        Semaphore producerSemaphore = new Semaphore(6);
        Semaphore consumerSemaphore = new Semaphore(0);

        Producer p1 = new Producer(store, 6, "p1", producerSemaphore, consumerSemaphore);
        Producer p2 = new Producer(store, 6, "p2", producerSemaphore, consumerSemaphore);
        Producer p3 = new Producer(store, 6, "p3", producerSemaphore, consumerSemaphore);

        Consumer c1 = new Consumer(store, 6, "c1", producerSemaphore, consumerSemaphore);
        Consumer c2 = new Consumer(store, 6, "c2", producerSemaphore, consumerSemaphore);
        Consumer c3 = new Consumer(store, 6, "c3", producerSemaphore, consumerSemaphore);
        Consumer c4 = new Consumer(store, 6, "c4", producerSemaphore, consumerSemaphore);
        Consumer c5 = new Consumer(store, 6, "c5", producerSemaphore, consumerSemaphore);
        Consumer c6 = new Consumer(store, 6, "c6", producerSemaphore, consumerSemaphore);

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
