package Threads;

public class MultiThreading04 {
    public static void main(String[] args) {
        Brackets2 brackets2 = new Brackets2();
        long startTime = System.currentTimeMillis();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 7; i++) {
                    brackets2.generateBrackets();
                }
            }
        });
        thread1.start();


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                brackets2.generateBrackets();
            }
        });
        thread2.start();

        long endTime = System.currentTimeMillis();

        // USE join
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
           e.printStackTrace();
        }

        System.out.println("Transaction Time : " + (endTime-startTime));

    }
}

class Brackets2 {
    public synchronized void generateBrackets() {
        for (int i = 1; i <= 10; i++) {
            if (i <= 5) {
                System.out.print("[");
            } else {
                System.out.print("]");
            }
        } // end of for
        System.out.println("");
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
