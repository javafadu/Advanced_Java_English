package Threads;

public class WaitNotify {

    public static int balance=0;

    public static void main(String[] args) {
        WaitNotify obje = new WaitNotify();

        // Thread1: withdraw
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                obje.withDraw(800);
            }
        });
        thread1.setName("Withdraw Thread");
        thread1.start();


        // Thread2 : deposit
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                obje.deposit(2000);
            }
        });
        thread2.setName("Deposit Thread");
        thread2.start();
    }

    // **** WITHDRAW method *****
    public void withDraw(int amount) {
        synchronized (this) {
            if(balance<=0 || balance<amount) {
                System.out.println("Balance value is less than requested value, please wait");
                try {
                    wait();  // wait for any incoming notify
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } // end of synchronized block
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // if the balance is sufficient or end of wait
        balance=balance-amount;
        System.out.println("Withdrawal was successful.");



    }



    // **** DEPOSIT method *****
    public void deposit(int amount) {
        balance=balance+amount;
        System.out.println("Deposit was successful. ");

        synchronized (this) {
            notify();  // send notify to waiting threads
        }
    }

}


