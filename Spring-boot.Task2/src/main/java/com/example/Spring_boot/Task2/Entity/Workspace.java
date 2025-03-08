package com.example.Spring_boot.Task2.Entity;

import com.example.Spring_boot.Task2.Enum.WorkspaceType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Workspace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private String location;

    private String type; // Physical or Virtual

    //    task2
    @Lob
    private String description;
    @CreationTimestamp
    private LocalDateTime createdDate; // Avtomatik yaradılma vaxtı
    @UpdateTimestamp
    private LocalDateTime updatedDate; // Avtomatik yeniləmə vaxtı

    //task2
    @PrePersist
    public void prePersist() {
        // Hər hansı bir əməliyyat, məsələn, başlanğıc məlumatlarını təyin edə bilərsiniz
        if (this.startDate == null) {
            this.startDate = LocalDateTime.now();
        }
    }

    //    task2
    @PreUpdate
    public void preUpdate() {
        // Hər hansı bir əməliyyat, məsələn, yeniləmə tarixini təyin edə bilərsiniz
        this.updatedDate = LocalDateTime.now();
    }

    //    task2
    @Enumerated(EnumType.STRING)
    private WorkspaceType workspaceType; // Private, Shared, Virtual

}
