package com.smartmes.maintenance.controller;

import com.smartmes.maintenance.dto.TechnicianResponseDto;
import com.smartmes.maintenance.service.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/technician")
    public List<TechnicianResponseDto> getAllTechnicians() {
        return employeeService.findAllTechnicians();
    }
}
