package org.alaa.entityrelations.controller;

import lombok.RequiredArgsConstructor;
import org.alaa.entityrelations.model.Department;
import org.alaa.entityrelations.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        return ResponseEntity.ok(departmentService.addDepartment(department));
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        return new ResponseEntity<>(departmentService.getAllDepartment(), HttpStatus.OK);
    }
}
