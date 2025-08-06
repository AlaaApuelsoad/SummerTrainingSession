package org.alaa.entityrelations.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.alaa.entityrelations.model.Employee;
import org.alaa.entityrelations.model.Laptop;
import org.alaa.entityrelations.repository.LaptopRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LaptopService {

    private final LaptopRepository laptopRepository;


    public Laptop addLaptop(Laptop laptop) {
        return laptopRepository.save(laptop);
    }


}
