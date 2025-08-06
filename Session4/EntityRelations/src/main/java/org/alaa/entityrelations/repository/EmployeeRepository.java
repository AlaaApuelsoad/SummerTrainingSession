package org.alaa.entityrelations.repository;

import org.alaa.entityrelations.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    @Query(value = "SELECT CONCAT(e.first_name,' ',e.last_name) AS \"Employee Full Name\",\n" +
            "d.department_name AS \"Department Name\", CONCAT(brand,' ',model) AS \"Laptop Model\"\n" +
            "from comp_employees e \n" +
            "join \n" +
            "comp_department d\n" +
            "on e.department_id = d.id\n" +
            "join comp_laptop l\n" +
            "on\n" +
            "e.laptop_id = l.id;", nativeQuery = true)
    List<Map<String,Object>> getEmployeeData();
}
