package Threads;

public class Volatile {

    volatile public static int flag = 0;
    // volatile : use variable in Ram, not use CPU caches

    public static void main(String[] args) {
        // Thread1:
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    if(flag==0) {
                        // if thread1 uses CPU cache for flag, flag will not change and
                        // there may be stack over flow
                        // to prevent this issue, we set flag as volatile **************
                        System.out.println("Thread 1 is working");
                    } else {
                        break;
                    }
                }
            }
        });
        thread1.start();

        // Thread2
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                flag=1;
                // if thread2 uses CPU cache for flag, flag will not changed to 1
                // there may be stack over flow in thread1 run method
                // to prevent this issue, we set flag as volatile **************
                System.out.println("Flag value is changed to 1");
            }
        });
        thread2.start();
    }

}
