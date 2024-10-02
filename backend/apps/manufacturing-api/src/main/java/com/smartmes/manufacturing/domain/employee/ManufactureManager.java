package com.smartmes.manufacturing.domain.employee;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("ManufactureManager")
public class ManufactureManager extends Employee {

    public ManufactureManager() {
        super();
    }
}

