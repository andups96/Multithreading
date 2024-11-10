package introToThreads;

public class Client {
    public static void main(String[] args) {
        HelloWorldPrinter helloWorldPrinter = new HelloWorldPrinter();
        for(int i = 0; i < 10; i++) {
            Thread thread = new Thread(helloWorldPrinter);
            thread.start();
        }

        for(int i = 0; i < 10; i++) {
            Thread thread = new HelloWorldPrinter2();
            thread.start();
        }
    }
}
