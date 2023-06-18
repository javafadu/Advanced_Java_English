package Threads;

import java.util.concurrent.Semaphore;

public class Semaphore01 {

    public static void main(String[] args) throws InterruptedException {
        // create thread slot numbers
        Semaphore semaphore = new Semaphore(4);
        Thread.sleep(2000);
        System.out.println("Total parking slot number is "+ semaphore.availablePermits());

        Car car1 = new Car("Car-1",semaphore);
        car1.start();

        Car car2 = new Car("Car-2",semaphore);
        car2.start();

        Car car3 = new Car("Car-3",semaphore);
        car3.start();

        Car car4 = new Car("Car-4",semaphore);
        car4.start();

        Car car5 = new Car("Car-5",semaphore);
        car5.start();

        Car car6 = new Car("Car-6",semaphore);
        car6.start();



    } // end of main

} // end of public

class Car extends Thread {

    private String name;
    Semaphore semaphore;

    // constructor
    public Car(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        try {
            System.out.println(name + " is parking now");
            semaphore.acquire(); // trying to park (load the empty thread)
            System.out.println(name+ " has parked");

            // parking time : 4 hours
            for (int i = 1; i <=4 ; i++) {
                System.out.println(name + " at the parrk for "+i + " hours");
                Thread.sleep(4000);
            }

            System.out.println(name + " left the park");
            semaphore.release(); // has left the park (empty thread slot)

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
