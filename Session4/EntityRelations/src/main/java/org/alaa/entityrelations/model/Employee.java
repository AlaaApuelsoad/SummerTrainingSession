package org.alaa.entityrelations.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "comp_employees")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
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
    private LocalDate birthDate;

    //composite Attribute
    @Embedded
    private Address address;

    //derivedAttribute
    @Transient
    private int age;

    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "laptop_id",referencedColumnName = "id")
    private Laptop laptop;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id",referencedColumnName = "id")
    @JsonBackReference(value = "empDepRef")
    private Department department;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "emp_project", joinColumns = @JoinColumn(name = "empi_id",referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "project_id",referencedColumnName = "id"))
    private List<Project> projects;

    public int getAge() {
       return LocalDate.now().compareTo(this.birthDate);
    }


}
