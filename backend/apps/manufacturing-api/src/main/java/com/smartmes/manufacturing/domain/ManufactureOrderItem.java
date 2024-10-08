package com.smartmes.manufacturing.domain;

import com.smartmes.manufacturing.enumeration.ShiftType;
import com.smartmes.manufacturing.enumeration.UnitMeasurementType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "manufacture_order_items")
public class ManufactureOrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Builder.Default
    private Integer quantity = 0;

    @Builder.Default
    private Integer nonConformingQuantity = 0;

    @NotNull
    @Enumerated(EnumType.STRING)
    private UnitMeasurementType unit;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ShiftType shift;

    @ManyToOne
    @JoinColumn(name = "manufacture_order_id")
    private ManufactureOrder order;
}
