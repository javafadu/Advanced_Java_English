package AdvancePractice.multithreads.countdownlatch;

import java.time.LocalDate;

public class AppointmentCenter {

    private static LocalDate day = LocalDate.now();

    public synchronized LocalDate getAppointmentDate() {
        day=day.plusDays(1);
        return  day;
    }
}
