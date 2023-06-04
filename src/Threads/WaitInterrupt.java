package Threads;

public class WaitInterrupt {

    static public int balance = 0;
    public static void main(String[] args) {

        WaitInterrupt object = new WaitInterrupt();

        // Withdraw Thread
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                object.withdraw(800);
            }
        });
        thread1.setName("Withdraw Thread");
        thread1.start();


        // Deposit Thread
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                object.deposit(2000);
                thread1.interrupt(); // thread2 finishes thread1 here
            }
        });
        thread2.setName("Deposit Thread");
        thread2.start();


    }

    // Withdraw Method
    public void withdraw(int amount) {
        synchronized (this) {
            if(balance<=0 || balance<amount) {
                System.out.println("Waiting for deposit");
                try {
                    wait();
                } catch (InterruptedException e) {
                   //  throw new RuntimeException(e);
                    balance-=amount;
                    System.out.println("Withdraw Successful");
                }
            } // end of if


        }
    }

    // Deposit Method
    public void deposit(int amount) {
        balance+=amount;
        System.out.println("Deposit Success ");
    }


}
