package Threads;

public class ThreadCreationWays {

    public static void main(String[] args) {
        // First working thread is main thread, control it
        System.out.println("Current Thread : "+Thread.currentThread().getName()); // main

        // Way-1: **** extends Thread Way *****
        MyThread thread1 = new MyThread();
        thread1.start(); // start a new thread and works run() method
        // thread1.run(); run() method works but not creating a new thread.

        // Way-2: **** implements Runnable class ****
        MyRunnable runnable = new MyRunnable();
        Thread thread2 = new Thread(runnable);
        thread2.start();

        // Way-3: **** Anonymous Thread (Interface) ****
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000); // sleep 3 seconds
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Anonymous thread is working");
            }
        });
        // thread3.setName("Thread3"); // --> thread naming
        thread3.start();


        // Way-4: **** Anonymous Thread (with lambda expression) ****
        Thread thread4 = new Thread(()->{
            System.out.println("Coded with Lambda thread is working ");

        });
        thread4.start();

        // check inner transaction when it writes
        System.out.println("Main thread is stopped");


        // Way-5: **** Anonymous Thread (with lambda expression) ****
        Thread thread5 = new Thread(()-> {
            System.out.println("Coded with Lambda2 thread is working");
        });
        thread5.start();

    }

}

// WAY-1 : extends Thread Class
class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("MyThread thread is working");
    }
}

// WAY-2 : implements Runnable interface
class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("MyRunnable thread is working");
    }
}
