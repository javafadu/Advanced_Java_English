package AdvancePractice.multithreads.creation;


public class ThreadCreation2 {
    public static void main(String[] args) throws InterruptedException {

        // TASK2: Create a class (name: Counter) implements Runnable
        // Create 2 threads to write chars from a to z

        // TASK3: Before starting threat print "It is starting"
        // after writing all chars pring "It has been finished"

        System.out.println("*** It is starting ****");

        Chars chars1 = new Chars(1);
        Thread thread1 = new Thread(chars1);
        thread1.start();

        Chars chars2 = new Chars(2);
        Thread thread2 = new Thread(chars2);
        thread2.start();


        thread1.join();
        thread2.join();
        System.out.println("*** It has been finished ****");

    }
}

class Chars implements Runnable {

    private int threadNo;

    public Chars(int threadNo) {
        this.threadNo = threadNo;
    }

    @Override
    public void run() {
        for (char i = 'a'; i <='z' ; i++) {
            System.out.println("Thread No: "+threadNo + " - i : "+i);
        }
    }
}
