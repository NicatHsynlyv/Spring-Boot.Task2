package com.example.Spring_boot.Task2.Service;

import com.example.Spring_boot.Task2.Entity.Reservation;
import com.example.Spring_boot.Task2.Enum.ReservationStatus;
import com.example.Spring_boot.Task2.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getReservationsWithinDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return reservationRepository.findReservationsWithinDateRange(startDate, endDate);
    }

    public List<Reservation> getAvailableReservationsForWorkspace(Long workspaceId, LocalDateTime date) {
        return reservationRepository.findAvailableReservationsForWorkspaceAtDate(workspaceId, date);
    }
//task2
    public List<Reservation> getReservationsByStatus(ReservationStatus status) {
        return reservationRepository.findReservationsByStatus(status);
    }
}
