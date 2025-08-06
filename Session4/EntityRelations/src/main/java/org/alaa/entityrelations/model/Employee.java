package org.alaa.entityrelations.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "comp_employees")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Employee {

    @Id
    @SequenceGenerator(initialValue = 100,allocationSize = 1,sequenceName = "emp_seq",name = "emp_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "emp_seq")
    private Long id;

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private BigDecimal salary;

    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "laptop_id",referencedColumnName = "id")
    private Laptop laptop;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id",referencedColumnName = "id")
//    @JsonBackReference(value = "empDepRef")
    private Department department;

}
