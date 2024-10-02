package com.smartmes.maintenance.domain.employee;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("MaintenanceManager")
public class MaintenanceManager extends Employee {

    public MaintenanceManager() {
        super();
    }
}
