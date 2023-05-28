package AdvancePractice.multithreads.creation;

public class ThreadCreation3 {

    public static void main(String[] args) {

        // TASK-4 : Create a thread using Anonymous Class
        // create thread using lambda expression


        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                Thread.currentThread().setName("thread1");
                String name = Thread.currentThread().getName();
                for (int i = 0; i < 100; i++) {
                    System.out.println(name+" "+i);
                }
            }
        });


        Thread thread2 = new Thread(() -> {
            Thread.currentThread().setName("thread2");
            String name = Thread.currentThread().getName();
            for (int i = 0; i < 100; i++) {
                System.out.println(name+" "+i);
            }
        });

        thread1.start();
        thread2.start();

    }


}
