package AdvancePractice.multithreads.synchronization;

/*
TASK : Create an appointment application
       The App should make an appointment for the next available day for each request.
 */
public class AppointmentApp {

    public static void main(String[] args) {

        String[] users = {"User1", "User2", "User3","User4","User5"};
        AppointmentCenter appointmentCenter = new AppointmentCenter();


        for (String user:users
             ) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Thread.currentThread().setName(user);
                    String name = Thread.currentThread().getName();
                    System.out.format("Dear %-10s, Appointment Date: %10s %n",name, appointmentCenter.getAppointmentDate());

                }
            });
            thread.start();
        }
        



    }

}
