package Threads;

// In case of reaching same source by different threads
public class MultiThreading02 {

    public static int counter=0;
    public static void main(String[] args) {
        // TASK: Create 2 separated threads and reach same source

        // Thread1
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Counter.count();
                System.out.println("Thread 1 started");
            }
        });
        thread1.start();

        // thread1.join();
        // for small codes it works but long codes it is not efficient.
        // we use "synchronized" in the related method.


        // Thread2
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Counter.count();
                System.out.println("Thread 2 started");
            }
        });
        thread2.start();
    }



}

class Counter {
    // synchronized : synchronizing access threads, one tread works, another thread waits until previous thread finishes.
    // we have queued the threads that reach this method.
    public synchronized static void count() {
        for (int i = 1; i <= 1000; i++) {
            MultiThreading02.counter++;
        }
        System.out.println("Counter "+MultiThreading02.counter);
    }
}
