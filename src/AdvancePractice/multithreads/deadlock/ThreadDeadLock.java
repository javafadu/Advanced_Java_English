package AdvancePractice.multithreads.deadlock;
/*
NOTES:
Deadlock occurs when two or more processes mutually want to access resources locked by each other.


Since both processes are constantly waiting for each other, system resources are adversely affected.
Especially the processor value of the server is wasted.
This adversely affects the performance of the server and may even render the server unresponsive.
*/
/*
TASK :  tom and jerry
Tom: he uses an eraser, he needs a pencil, but the dog uses the pencil
jerry: uses the ruler, needs the eraser but Tom uses the eraser
dog: uses the pencil needs the ruler but jerry uses the ruler
 */
public class ThreadDeadLock {
    public static void main(String[] args) {
        String pencil = "pencil";
        String ruler = "ruler";
        String eraser = "eraser";

        Thread t1 = new Thread(new SyncThread(pencil,ruler),"Dog");
        Thread t2 = new Thread(new SyncThread(eraser,pencil),"Tom");
        Thread t3 = new Thread(new SyncThread(ruler,eraser),"Jerry");

        t1.start();
        t2.start();
        t3.start();

    }
}

class SyncThread implements Runnable {

    private String obj1;
    private String obj2;

    public SyncThread(String obj1, String obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name+" wants "+obj1);
        synchronized (obj1) {
            System.out.println(name+" picked up "+obj1);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name+" wants "+obj2);
            synchronized (obj2) {
                System.out.println(name+" picked up "+obj2);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(name+" drop off "+obj2);
            }
            System.out.println(name+" drop off "+obj1);
            System.out.println(name+" finished the job");
        }
    }
}
