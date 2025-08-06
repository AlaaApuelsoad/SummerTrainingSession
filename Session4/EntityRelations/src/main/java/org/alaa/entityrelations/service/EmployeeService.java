package org.alaa.entityrelations.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.alaa.entityrelations.model.Department;
import org.alaa.entityrelations.model.Employee;
import org.alaa.entityrelations.model.Laptop;
import org.alaa.entityrelations.repository.DepartmentRepository;
import org.alaa.entityrelations.repository.EmployeeRepository;
import org.alaa.entityrelations.repository.LaptopRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final LaptopRepository laptopRepository;
    private final DepartmentRepository departmentRepository;


    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteEmployeeById(Long empId) {
        employeeRepository.deleteById(empId);
    }

    public Employee addLaptopToEmployee(Long empId, Long lapId) {
        Laptop laptop = laptopRepository.findById(lapId).orElseThrow(
                () -> new EntityNotFoundException("Laptop with id: " + lapId + " not found")
        );

        Employee employee = employeeRepository.findById(empId).orElseThrow(
                () -> new EntityNotFoundException("Employee with id: " + empId + " not found")
        );

        employee.setLaptop(laptop);
        return employeeRepository.save(employee);
    }

    public Employee addEmpToDept(Long empId, Long lapId) {
        Employee employee = employeeRepository.findById(empId).orElseThrow(
                () -> new EntityNotFoundException("Employee with id: " + empId + " not found")
        );
        Department department = departmentRepository.findById(lapId).orElseThrow(
                ()-> new EntityNotFoundException("Department with id: " + lapId + " not found")
        );
        employee.setDepartment(department);
        return employeeRepository.save(employee);
    }

    public List<Map<String,Object>> getEmployeeData(){
        return employeeRepository.getEmployeeData();
    }


}
