package org.alaa.entityrelations.controller;

import lombok.RequiredArgsConstructor;
import org.alaa.entityrelations.dto.EmployeeInfoDto;
import org.alaa.entityrelations.dto.EmployeeRegisterDto;
import org.alaa.entityrelations.model.Employee;
import org.alaa.entityrelations.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;


    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.CREATED);
    }

    @DeleteMapping("/{empId}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable Long empId) {
        employeeService.deleteEmployeeById(empId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{empId}/{lapId}")
    public ResponseEntity<Object> addLapToEmployee(@PathVariable Long empId, @PathVariable Long lapId) {
        Map<String,Object> res = new HashMap<>();
        try {
           return new ResponseEntity<>(employeeService.addLaptopToEmployee(empId,lapId), HttpStatus.ACCEPTED);
        }catch (Exception e){
            res.put("message",e.getMessage());
            return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @PostMapping("/dept/{empID}/{depID}")
    public ResponseEntity<?> addEmpToDept(@PathVariable Long empID, @PathVariable Long depID) {
        Map<String,Object> res = new HashMap<>();
        try {
            return new ResponseEntity<>(employeeService.addEmpToDept(empID,depID), HttpStatus.ACCEPTED);
        }catch (Exception e){
            res.put("message",e.getMessage());
            return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/empData")
    public ResponseEntity<List<Map<String,Object>>> getEmployeeData(){
        return new ResponseEntity<>(employeeService.getEmployeeData(), HttpStatus.OK);
    }

    @PostMapping("/assignToProject/{empId}/{projId}")
    public ResponseEntity<Employee> assignToProject(@PathVariable Long empId, @PathVariable Long projId) {
        return new ResponseEntity<>(employeeService.assignToProject(empId,projId),HttpStatus.ACCEPTED);
    }

    @GetMapping("/{empId}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long empId) {
        return new ResponseEntity<>(employeeService.getEmployeeById(empId),HttpStatus.ACCEPTED);
    }

    @PostMapping("/validation")
    public ResponseEntity<EmployeeRegisterDto> validateEmployee(@Validated  @RequestBody EmployeeRegisterDto employeeRegisterDto) {
        return new ResponseEntity<>(employeeRegisterDto, HttpStatus.ACCEPTED);
    }

}
