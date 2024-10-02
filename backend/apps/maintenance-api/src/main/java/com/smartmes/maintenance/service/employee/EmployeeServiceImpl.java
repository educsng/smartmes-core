package com.smartmes.maintenance.service.employee;

import com.smartmes.maintenance.domain.employee.Employee;
import com.smartmes.maintenance.domain.employee.Technician;
import com.smartmes.maintenance.dto.TechnicianResponseDto;
import com.smartmes.maintenance.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.smartmes.maintenance.enumeration.EmployeeType.TECHNICIAN;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Override
    public Technician mustFindTechnicianById(Long employeeId) {
        return this.findByIdAndType(employeeId, TECHNICIAN.getValue())
            .map(Technician.class::cast)
            .orElseThrow(() -> new RuntimeException("O identificador do técnico não foi encontrado, insira um identificador válido"));
    }

    @Override
    public List<TechnicianResponseDto> findAllTechnicians() {
        return employeeRepository.findAllTechnicians().stream()
            .map(technician -> new TechnicianResponseDto(technician.getId(), technician.getName(), technician.getSpecialization().name()))
            .toList();
    }

    private Optional<Employee> findByIdAndType(Long employeeId, String type) {
        return employeeRepository.findByIdAndEmployeeType(employeeId, type);
    }
}
