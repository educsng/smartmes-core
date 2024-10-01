package com.smartmes.maintenance.dto;

import jakarta.validation.constraints.Max;
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
    @Max(value = 500, message = "O campo reason deve ter no maximo 500 caracteres")
    private String reason;

    @NotBlank(message = "O campo manufactureOrderNumber é obrigatório")
    private Long manufactureOrderNumber;

    @NotNull(message = "O campo equipmentId é obrigatório")
    private Long equipmentId;
}
