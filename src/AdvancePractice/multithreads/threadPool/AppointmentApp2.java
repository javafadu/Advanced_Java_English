package AdvancePractice.multithreads.threadPool;

/*
NOTES:
    - Working with thread is expensive, each thread requires / needs sources on the system
    - These sources are CPU, RAM, etc.
    - We can optimize and limit using threads for source efficiency

    *****
    For above reason, we can create a thread pool with limited capacity,
    we can fill these thread pool with created threads which are already created before and ready to use
    -> This way provides us more performance with less sources (efficiency)

 */


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
TASK :
    Create an appointment app
    The application provides next day availability for each request.
    total application number is : 5
    create a thread pool and use 3 threads
 */
public class AppointmentApp2 {

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(3);

        String[] users = {"Tolstoy", "Balzac","Victor Hugo","George Orwell","Dostoevsky"};

        AppointmentCenter2 appCenter = new AppointmentCenter2();


        for (String user:users
             ) {
            MyThread thread = new MyThread(appCenter);
            service.execute(thread);
        }

        service.shutdown();

    }

}

class MyThread extends Thread {

    private AppointmentCenter2 appCenter;

    public MyThread(AppointmentCenter2 appCenter) {
        this.appCenter = appCenter;
    }

    @Override
    public void run() {
        String tname= Thread.currentThread().getName();
        System.out.println("++ " +tname+ " has started");
        System.out.println("Appointment Date: "+tname+" "+appCenter.getAppointmentDate());
        System.out.println(".. "+tname+ " has finished");
    }
}
