package com.smartmes.maintenance.dto;

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
public class MaintenanceOrderIncidentRequestDto {

    @NotBlank
    private String reason;

    @NotNull
    private Long equipmentId;
}
