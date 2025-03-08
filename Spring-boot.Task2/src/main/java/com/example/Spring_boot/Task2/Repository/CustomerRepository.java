package com.example.Spring_boot.Task2.Repository;

import com.example.Spring_boot.Task2.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Müştərini adı ilə tapır
    @Query("SELECT c FROM Customer c WHERE c.name LIKE %:name%")
    List<Customer> findCustomersByName(@Param("name") String name);


    // Müştərini email ilə tapır
    @Query("SELECT c FROM Customer c WHERE c.email = :email")
    Customer findCustomerByEmail(@Param("email") String email);
}
