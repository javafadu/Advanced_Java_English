package AdvancePractice.multithreads.interrupt;

import AdvancePractice.multithreads.waitNotify.ShopWaitNotify;

/*
TASK : Create an APP controlling stock number in the market
       - If the product is not enough to buy, wait to be stocked
       - When the new products are added into the stock, people can shop
 */
public class ShopInterrupt {


    public static volatile int stock = 0;
    public static void main(String[] args) {

        ShopWaitNotify shop = new ShopWaitNotify();

        Thread customerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                shop.productBuy(5);
            }
        });

        Thread supplierThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000); // to see the result
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                shop.productSupply(3);
                customerThread.interrupt();

            }
        });

        customerThread.setName("Customer");
        supplierThread.setName("Supplier");
        customerThread.start();
        supplierThread.start();


    }

    // Sales Method
    public synchronized void productBuy(int amount) {
        if(stock<amount) {
            System.out.printf("");
            System.out.println(Thread.currentThread().getName()+ "Costumer wants to buy");
            System.out.println("There is no sufficient stock to sell: "+stock);
            System.out.println("Customer is waiting for product receipt");
            // wait
            try {
                wait();
            } catch (InterruptedException e) {
                if(amount<stock) {
                    System.out.println();
                    System.out.println(Thread.currentThread().getName()+ "Costumer wants to buy");
                    System.out.println(amount + " amount has been reduced from current stock" );
                    stock-=amount;
                    System.out.println("Current Stock Number : "+stock);
                } else {
                    System.out.println();
                    System.out.println(Thread.currentThread().getName()+ "Costumer wants to buy");
                    System.out.println("There is no enough product in the stock: "+stock);
                    System.out.println("Please come back later");

                }
            }

        };

        if(amount<stock) {
            System.out.println();
            System.out.println(Thread.currentThread().getName()+ "Costumer wants to buy");
            System.out.println(amount + " amount has been reduced from current stock" );
            stock-=amount;
            System.out.println("Current Stock Number : "+stock);
        } else {
            System.out.println();
            System.out.println(Thread.currentThread().getName()+ "Costumer wants to buy");
            System.out.println("There is no enough product in the stock");
            System.out.println("Please come back later");

        }
    }

    // Supply Method
    public synchronized void productSupply(int amount) {
        System.out.println();
        System.out.println(Thread.currentThread().getName()+" wants to add product into the stock");
        System.out.println("new products are being added to the stock.");
        stock+=amount;
        System.out.println("Current Stock Number : "+stock);


    }

}
