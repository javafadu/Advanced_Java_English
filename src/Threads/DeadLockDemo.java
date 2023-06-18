package Threads;

// When a deadlock occurs in which situation?
public class DeadLockDemo {
    public static void main(String[] args) {
        final String lock1 = "lock1";
        final String lock2 = "lock2";

        // thread1
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1) {
                    System.out.println("Thread1, locked  lock1 variable");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    synchronized (lock2) {
                        System.out.println("Thread1, locked lock2 variable");
                    }
                }
            }
        });
        thread1.start();


        // thread1
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2) {
                    System.out.println("Thread2, locked  lock2 variable");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    synchronized (lock1) {
                        System.out.println("Thread2, locked lock1 variable");
                    }
                }
            }
        });
        thread2.start();

    }

}
