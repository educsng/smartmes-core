package com.smartmes.maintenance.service.employee;

import com.smartmes.maintenance.domain.Employee;
import com.smartmes.maintenance.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee mustFindById(Long employeeId) {
        return this.findById(employeeId)
            .orElseThrow(() -> new RuntimeException("O identificador do colaborador não foi encontrado, insira um identificador válido"));
    }

    private Optional<Employee> findById(Long employeeId) {
        return employeeRepository.findById(employeeId);
    }
}
