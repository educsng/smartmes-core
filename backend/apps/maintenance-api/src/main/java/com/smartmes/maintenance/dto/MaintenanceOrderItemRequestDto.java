package com.smartmes.maintenance.dto;

import com.smartmes.maintenance.enumeration.ShiftType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceOrderItemRequestDto {

    private String description;
    private Long employeeId;
    private ShiftType shift;
}
