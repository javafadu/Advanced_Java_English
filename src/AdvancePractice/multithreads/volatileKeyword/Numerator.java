package AdvancePractice.multithreads.volatileKeyword;

public class Numerator {

    private volatile static int counter = 0;
    // volatile keyword keeps the variable in the RAM but
    // if all thread access this variable at the same time, volatile can not do ordering / sync
    // So we need to use synchronized

    public  void getOrderNumber() {
        String name = Thread.currentThread().getName();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (this) {
            counter++;
            System.out.format("Dear  %-10s your queuing number: %3d %n",name,counter);
        }


    }

}
