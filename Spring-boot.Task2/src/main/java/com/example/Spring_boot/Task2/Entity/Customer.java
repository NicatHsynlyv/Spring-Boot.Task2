package com.example.Spring_boot.Task2.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @Email
    private String email;

//    task2
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Reservation> reservation;

}
