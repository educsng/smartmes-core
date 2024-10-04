package com.smartmes.maintenance.domain.equipment;

import com.smartmes.maintenance.enumeration.EquipmentStatus;
import com.smartmes.maintenance.enumeration.EquipmentType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "equipments")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @NotBlank
    private String serialNumber;

    @NotBlank
    private String model;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EquipmentType type;

    private Double latitude;

    private Double longitude;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private EquipmentStatus status = EquipmentStatus.AVAILABLE;
}
