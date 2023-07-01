package AdvancePractice.multithreads.deadlock;

public class WithoutDeadLock {
    public static void main(String[] args) {
        String pencil = "pencil";
        String ruler = "ruler";
        String eraser = "eraser";

        Thread t1 = new Thread(new SyncThread2(pencil,ruler),"Dog");
        Thread t2 = new Thread(new SyncThread2(eraser,pencil),"Tom");
        Thread t3 = new Thread(new SyncThread2(ruler,eraser),"Jerry");

        t1.start();
        t2.start();
        t3.start();

    }
}

class SyncThread2 implements Runnable {

    private String obj1;
    private String obj2;

    public SyncThread2(String obj1, String obj2) {
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


            System.out.println(name+" drop off "+obj1);
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

        System.out.println(name+" finished the job");

    }
}
