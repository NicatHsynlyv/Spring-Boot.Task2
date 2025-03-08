package com.example.Spring_boot.Task2.Entity;


import com.example.Spring_boot.Task2.Enum.ReservationStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
@Setter
@Getter
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @ManyToOne(fetch = FetchType.LAZY) //task2
    private Workspace workspace;

    @ManyToOne
    private Customer customer;

//    task2

    @CreationTimestamp
    private LocalDateTime createdDate; // Avtomatik yaradılma vaxtı
    @UpdateTimestamp
    private LocalDateTime updatedDate; // Avtomatik yeniləmə vaxtı

//task2
    @PrePersist
    public void prePersist() {
        if (this.startDate == null) {
            this.startDate = LocalDateTime.now();
        }
    }
//task2
    @PreUpdate
    public void preUpdate() {
        this.updatedDate = LocalDateTime.now();
    }
//    task2
    @Enumerated(EnumType.STRING) // Enum dəyəri STRING formatında saxlanacaq
    private ReservationStatus status; // Yeni əlavə etdiyimiz sahə

}
