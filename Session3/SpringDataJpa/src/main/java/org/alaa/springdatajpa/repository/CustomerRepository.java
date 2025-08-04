package org.alaa.springdatajpa.repository;

import org.alaa.springdatajpa.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    //JPQL
    @Query("SELECT c FROM Customer c WHERE c.lastName = ?1")
//    @Query(value = "SELECT * FROM comp_customers WHERE emp_last_name = :lastName",nativeQuery = true)//SQL Query
    Customer findByLastName(String lastName);

    List<Customer> findByFirstNameContainingIgnoreCase(String firstName);

//    @Query(value = "SELECT * FROM comp_customers ORDER BY id ASC",nativeQuery = true)
    List<Customer> findAllByOrderByIdDesc();

}
