package com.smartmes.maintenance.repository;

import com.smartmes.maintenance.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
