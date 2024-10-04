package com.smartmes.manufacturing.domain.user;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("Admin")
public class Admin extends Employee {

    public Admin() {
        super();
    }
}
