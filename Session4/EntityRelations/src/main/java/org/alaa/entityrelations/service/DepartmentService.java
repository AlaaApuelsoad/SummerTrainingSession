package org.alaa.entityrelations.service;

import lombok.RequiredArgsConstructor;
import org.alaa.entityrelations.model.Department;
import org.alaa.entityrelations.repository.DepartmentRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;


    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }
}
