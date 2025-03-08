package com.example.Spring_boot.Task2.Repository;

import com.example.Spring_boot.Task2.Entity.Reservation;
import com.example.Spring_boot.Task2.Enum.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface ReservationRepository extends GeneralRepository<Reservation, Long> {
    // Tarix aralığında olan rezervasiyaları tapır
    @Query("SELECT r FROM Reservation r WHERE r.startDate BETWEEN :startDate AND :endDate")
    List<Reservation> findReservationsWithinDateRange(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    // Müəyyən tarixdə iş yerinin mövcudluğunu yoxlayır
    @Query("SELECT r FROM Reservation r WHERE r.workspace.id = :workspaceId AND r.startDate < :date AND r.endDate > :date")
    List<Reservation> findAvailableReservationsForWorkspaceAtDate(@Param("workspaceId") Long workspaceId, @Param("date") LocalDateTime date);

//task2
    @Query("SELECT r FROM Reservation r WHERE r.status = :status")
    List<Reservation> findReservationsByStatus(@Param("status") ReservationStatus status);
}
