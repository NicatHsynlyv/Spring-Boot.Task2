package com.example.Spring_boot.Task2.Controller;

import com.example.Spring_boot.Task2.Entity.Reservation;
import com.example.Spring_boot.Task2.Enum.ReservationStatus;
import com.example.Spring_boot.Task2.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/date-range")
    public List<Reservation> getReservationsWithinDateRange(@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate) {
        return reservationService.getReservationsWithinDateRange(startDate, endDate);
    }

    @GetMapping("/available/{workspaceId}")
    public List<Reservation> getAvailableReservationsForWorkspace(@PathVariable Long workspaceId, @RequestParam LocalDateTime date) {
        return reservationService.getAvailableReservationsForWorkspace(workspaceId, date);
    }
//    task22
//    @GetMapping("/status/{status}")
//    public List<Reservation> getReservationsByStatus(@PathVariable ReservationStatus status) {
//        return reservationService.getReservationsByStatus(status);
//    }se

    @GetMapping("/status/{status}")
    public List<Reservation> getReservationsByStatus(@PathVariable String status) {
        ReservationStatus reservationStatus = ReservationStatus.valueOf(status.toUpperCase()); // String → Enum
        return reservationService.getReservationsByStatus(reservationStatus);
    }
}
