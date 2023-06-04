package AdvancePractice.multithreads.volatileKeyword;

/*
According to the performance issue, sometimes variables are kept in CPU Caches,
There are several seeds in the CPU and each threads works on different seeds of CPU,
For this reason, each thread keeps different values on the same variable
 */

/*
volatile: in case of any changes on variable/object, it guarantees that variable is seen by another threads.
volatile: variables are not stored in CPU caches, they are kept in RAM
 */
public class VolatileKeyword {

    // TASK : Create a counter app which is used in hospital or bank
    // app provides next number for each request.

    public static void main(String[] args) {
        Numerator numerator = new Numerator();

        // Thread1
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                numerator.getOrderNumber();

            }
        });
        thread1.setName("tr1");
        thread1.start();


        // Thread2
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                numerator.getOrderNumber();
            }
        });
        thread2.setName("tr2");
        thread2.start();


        // Thread3
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                numerator.getOrderNumber();
            }
        });
        thread3.setName("tr3");
        thread3.start();


    }

}





