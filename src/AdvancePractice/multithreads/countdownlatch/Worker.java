package AdvancePractice.multithreads.countdownlatch;

import javax.crypto.spec.PSource;
import java.util.concurrent.CountDownLatch;

public class Worker extends Thread{

    private String name;
    private CountDownLatch latch;

    public Worker(String name, CountDownLatch latch) {
        this.name = name;
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println(name+" thread started");
        System.out.println(name+ " is performaing some operations...");
        System.out.println(name+" thread ended");
        latch.countDown();

    }
}
