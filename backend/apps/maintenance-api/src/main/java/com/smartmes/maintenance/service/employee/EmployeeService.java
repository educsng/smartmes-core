package com.smartmes.maintenance.service.employee;

import com.smartmes.maintenance.domain.employee.Technician;
import com.smartmes.maintenance.dto.TechnicianResponseDto;

import java.util.List;

public interface EmployeeService {

    Technician mustFindTechnicianById(Long employeeId);

    List<TechnicianResponseDto> findAllTechnicians();
}
