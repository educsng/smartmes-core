package com.smartmes.manufacturing.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EmployeeType {

    ADMIN("Admin"),
    TECHNICIAN("Technician"),
    OPERATOR("Operator"),
    MAINTENANCE_MANAGER("MaintenanceManager"),
    MANUFACTURE_MANAGE("ManufactureManager");

    private final String value;
}
