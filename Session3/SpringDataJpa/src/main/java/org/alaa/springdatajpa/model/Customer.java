package org.alaa.springdatajpa.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comp_customers")
public class Customer {

    @Id
    @SequenceGenerator(initialValue = 100,allocationSize = 1,sequenceName = "emp_id_seq", name = "emp_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "emp_id_seq")
    private int id;

    @Column(name = "emp_first_name",nullable = false,length = 50)
    private String firstName;

    @Column(name = "emp_last_name",nullable = false,length = 50)
    private String lastName;

    @Column(unique = true,nullable = false,length = 100)
    private String email;

    @Column(unique = true,length = 11, nullable = false)
    private String phoneNumber;

}

