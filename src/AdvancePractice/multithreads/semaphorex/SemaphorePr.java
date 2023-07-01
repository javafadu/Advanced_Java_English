package AdvancePractice.multithreads.semaphorex;
/*
NOTES:
Semaphore is used to limit the number of threads that can access a resource
Synchronized: only one thread at the same time and blocks others
Semaphore: only n (defined) thread at the same time and blocks remains
 */

import java.util.concurrent.Semaphore;

/*
TASK: test cabin / pay desk
there are 3 test cabins and 5 people wants to use test cabins
use 5 threads for 5 people
 */
public class SemaphorePr {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);
        Person person1 = new Person("Name1",semaphore);
        Person person2 = new Person("Name2",semaphore);
        Person person3 = new Person("Name3",semaphore);
        Person person4 = new Person("Name4",semaphore);
        Person person5 = new Person("Name5",semaphore);

        person1.start();
        person2.start();
        person3.start();
        person4.start();
        person5.start();


    }

}

class Person extends Thread {

    private String name;
    private Semaphore semaphore;


    public Person(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
    }


    @Override
    public void run() {
        System.out.println(name+" wants to get into the test cabin");
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name+" entered the test cabin");
        System.out.println(name+" is inside of the cabin...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name+" is exiting outside of the cabin...");
        semaphore.release();
    }
}
