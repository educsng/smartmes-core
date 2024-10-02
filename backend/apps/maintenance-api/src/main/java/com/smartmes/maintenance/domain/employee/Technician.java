package com.smartmes.maintenance.domain.employee;

import com.smartmes.maintenance.enumeration.TechnicianSpecialization;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("Technician")
public class Technician extends Employee {

    @Enumerated(value = EnumType.STRING)
    private TechnicianSpecialization specialization;

    public Technician() {
        super();
    }
}
