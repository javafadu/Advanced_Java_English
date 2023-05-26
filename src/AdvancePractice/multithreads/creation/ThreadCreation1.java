package AdvancePractice.multithreads.creation;

public class ThreadCreation1 {

    public static void main(String[] args) {

        // TASK1: Create a class (name: Counter) extends Thread
        // Create 2 threads to write numbers from 1 to 100

        Counter counter1 = new Counter(1);
        counter1.start();
        Counter counter2 = new Counter(2);
        counter2.start();


    }

}

class Counter extends Thread {

    private int threadNo;

    Counter(int threadNo) {
        this.threadNo=threadNo;
    }

    @Override
    public void run() {
        for (int i = 1; i <=100 ; i++) {
            System.out.println("Thread No: "+threadNo + " - i : "+i);
        }
    }
}
