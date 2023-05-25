package Threads;

public class MultiThreading01 {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        CounterWithoutMultiThread counter1 = new CounterWithoutMultiThread(1);
        CounterWithoutMultiThread counter2 = new CounterWithoutMultiThread(2);
        counter1.countMe();
        System.out.println("-----------------");
        counter2.countMe();
        long endTime = System.currentTimeMillis();
        System.out.println("Without Multi Thread Time : "+(endTime-startTime));

        System.out.println("*************************");

        long startTime2 = System.currentTimeMillis();
        CounterWithMultiThread counter3 = new CounterWithMultiThread(1);
        CounterWithMultiThread counter4 = new CounterWithMultiThread(2);
        counter3.start();
        System.out.println("-----------------");
        counter4.start();
        counter3.join();  // wait until counter3 thread finishes
        counter4.join();  // wait until counter4 thread finishes
        long endTime2 = System.currentTimeMillis();
        System.out.println("Wit Multi Thread Time : "+(endTime2-startTime2));

    }

}

class CounterWithoutMultiThread{
    private int threadNumber;

    // constructor
    public CounterWithoutMultiThread(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    public void countMe() throws InterruptedException {
        for (int i = 1; i <=10 ; i++) {
            Thread.sleep(500);  // make slow 0.5 second (main thread)
            System.out.println("i: "+i+" Thread No: "+threadNumber);
        }
    }

}

class CounterWithMultiThread extends Thread{
    private int threadNumber;

    public CounterWithMultiThread (int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        try {
            countMe();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void countMe() throws InterruptedException {
        for (int i = 1; i <=10 ; i++) {
            Thread.sleep(500);  // make slow 0.5 second (main thread)
            System.out.println("i: "+i+" Thread No: "+threadNumber);
        }
    }
}
