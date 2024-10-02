package com.smartmes.maintenance.repository;

import com.smartmes.maintenance.domain.employee.Employee;
import com.smartmes.maintenance.domain.employee.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT * FROM employees WHERE id = :employeeId AND employee_type = :type LIMIT 1", nativeQuery = true)
    Optional<Employee> findByIdAndEmployeeType(Long employeeId, String type);

    @Query(value = "SELECT * FROM employees WHERE employee_type = 'Technician'", nativeQuery = true)
    List<Technician> findAllTechnicians();
}
