package org.alaa.entityrelations.dto;

import jakarta.persistence.Embedded;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.alaa.entityrelations.model.Address;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRegisterDto {


    @NotBlank(message = "Must not null")
    @Pattern(regexp = "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$",message = "must be in email format")
    private String email;

    @Size(min = 2,max = 11,message = "2 l 11")
    private String phoneNumber;
//    private String lastName;
//    private String username;
//    private String email;
//    private String password;
//    private LocalDate birthDate;
//    private Address address;
}
