package com.smartmes.maintenance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceOrderCreationResponseDto {
    private String message;
    private MaintenanceOrderResponseDto manufactureOrder;
}
