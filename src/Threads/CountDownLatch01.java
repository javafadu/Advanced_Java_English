package Threads;

import java.util.concurrent.CountDownLatch;

public class CountDownLatch01 {

    public static void main(String[] args) {

        // Send 4 thread as important, firstly start only 4 thread then start remains
        CountDownLatch latch = new CountDownLatch(4);

        // create threads
        WorkerThreads worker1 = new WorkerThreads("Worker1", 5000,latch);
        WorkerThreads worker2 = new WorkerThreads("Worker2", 7000,latch);
        WorkerThreads worker3 = new WorkerThreads("Worker3", 9000,latch);
        WorkerThreads worker4 = new WorkerThreads("Worker4", 11000,latch);


        // start threads
        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();

        //
        try {
            latch.await();  // waits until count down is 0
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName()+ " has finished");

    }

}

class WorkerThreads extends Thread {

    private int delay;
    private CountDownLatch latch;

    // constructor (2+1 parameters)
    public WorkerThreads(String name, int delay, CountDownLatch latch) {
        super(name);
        this.delay = delay;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
            System.out.println(Thread.currentThread().getName()+ " is running");
            latch.countDown(); // count down of executed threads
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
