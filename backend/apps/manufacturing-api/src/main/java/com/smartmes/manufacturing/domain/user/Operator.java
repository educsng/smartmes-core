package com.smartmes.manufacturing.domain.user;

import com.smartmes.manufacturing.enumeration.ShiftType;
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
@DiscriminatorValue("Operator")
public class Operator extends Employee {

    @Enumerated(value = EnumType.STRING)
    private ShiftType shift;

    public Operator() {
        super();
    }
}
