package com.smartmes.maintenance.dto;

import com.smartmes.maintenance.enumeration.MaintenanceOrderType;
import com.smartmes.maintenance.enumeration.MaintenancePriority;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceOrderCreationRequestDto {

    @NotBlank
    private String reason;

    @NotNull
    private Long equipmentId;

    private Long employeeId;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private MaintenancePriority priority;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private MaintenanceOrderType type;

}
