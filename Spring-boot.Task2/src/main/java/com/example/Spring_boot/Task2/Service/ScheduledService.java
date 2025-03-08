package com.example.Spring_boot.Task2.Service;

import com.example.Spring_boot.Task2.Entity.Reservation;
import com.example.Spring_boot.Task2.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

//task2

@Service
public class ScheduledService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ScheduledService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // Hər gün saat 02:00-da bitmiş rezervasiyaları silmək
    @Scheduled(cron = "0 0 2 * * ?")
    public void removeExpiredReservations() {
        LocalDateTime now = LocalDateTime.now();
        List<Reservation> expiredReservations = reservationRepository.findReservationsWithinDateRange(now.minusDays(1), now);
        reservationRepository.deleteAll(expiredReservations);
    }
}
