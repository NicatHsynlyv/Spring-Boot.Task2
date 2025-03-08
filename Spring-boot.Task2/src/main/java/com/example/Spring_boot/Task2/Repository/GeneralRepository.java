package com.example.Spring_boot.Task2.Repository;

import com.example.Spring_boot.Task2.Entity.Customer;
import com.example.Spring_boot.Task2.Entity.Reservation;
import com.example.Spring_boot.Task2.Entity.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GeneralRepository<T, K> {

    T delete(T entity);
    void save(T entity);
    T getById(K id);
    List<K> getAll();

    // İş yerini adı ilə tapır
    @Query("SELECT w FROM Workspace w WHERE w.name = :name")
    Optional<Workspace> findWorkspaceByName(@Param("name") String name);

    // Müştəriyə görə rezervasiyaları tapır
    @Query("SELECT r FROM Reservation r WHERE r.customer.id = :customerId")
    List<Reservation> findReservationsByCustomerId(@Param("customerId") Long customerId);

    // Müştəri adı ilə tapır
    @Query("SELECT c FROM Customer c WHERE c.name LIKE %:name%")
    List<Customer> findCustomersByPartialName(@Param("name") String name);

}
