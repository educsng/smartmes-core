package com.smartmes.maintenance.dto;

import com.smartmes.maintenance.enumeration.OrderStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceOrderUpdateRequestDto {

    @NotNull
    private OrderStatus orderStatus;

    List<MaintenanceOrderItemRequestDto> items;
}
