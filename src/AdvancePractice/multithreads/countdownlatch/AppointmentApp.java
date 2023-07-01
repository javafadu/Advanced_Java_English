package AdvancePractice.multithreads.countdownlatch;

/*
NOTES:
All threads that call the "await()" method of the CountDownLatch instance are suspended until the countdown is complete.
When the countdown is completed, in a sense, the door slider opens and the waiting threads continue to run.
For example, until "n" threads report that they have finished (i.e., each one decrements the counter and
It can be used in a situation where we want the main thread to wait (until the value of the
counter finally reaches zero).
 */

import AdvancePractice.multithreads.threadPool.AppointmentCenter2;

import java.util.concurrent.CountDownLatch;

/*
TASK: Design an appointment creation application. (AppoinmentCenter) The
application should date one day later for each request.
Before the threads that give the appointment date,
make sure that the threads that perform some operations before
the appointment run.
 */
public class AppointmentApp {
    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(3);
        String[] users = {"Name1", "Name2","Name3"};
        AppointmentCenter center = new AppointmentCenter();

        for (String user: users
             ) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Appointment Date : "+center.getAppointmentDate());
                }
            });
            thread.start();
        }

        Worker worker1 = new Worker("Worker1",countDownLatch);
        Worker worker2 = new Worker("Worker2",countDownLatch);
        Worker worker3 = new Worker("Worker3",countDownLatch);


        worker1.start();
        worker2.start();
        worker3.start();

    }

}
