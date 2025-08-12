package org.alaa.entityrelations.controller;

import lombok.RequiredArgsConstructor;
import org.alaa.entityrelations.model.Laptop;
import org.alaa.entityrelations.service.LaptopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/laptops")
@RequiredArgsConstructor
public class LaptopController {

    private final LaptopService laptopService;


    @PostMapping
    public ResponseEntity<Laptop> addLaptop(@RequestBody Laptop laptop) {
        return new ResponseEntity<>(laptopService.addLaptop(laptop), HttpStatus.CREATED);
    }



}
