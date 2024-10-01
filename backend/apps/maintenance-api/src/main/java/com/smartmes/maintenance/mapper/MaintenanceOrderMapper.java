package com.smartmes.maintenance.mapper;

import com.smartmes.maintenance.domain.MaintenanceOrder;
import com.smartmes.maintenance.dto.MaintenanceOrderResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class MaintenanceOrderMapper {

    public Page<MaintenanceOrderResponseDto> toMaintenanceOrderResponseDto(Page<MaintenanceOrder> maintenanceOrders) {
        return maintenanceOrders.map(MaintenanceOrderMapper::fromMaintenanceOrder);
    }

    private static MaintenanceOrderResponseDto fromMaintenanceOrder(MaintenanceOrder maintenanceOrder) {
        return MaintenanceOrderResponseDto.builder()
            .id(maintenanceOrder.getId())
            .reason(maintenanceOrder.getReason())
            .createdAt(maintenanceOrder.getCreatedAt())
            .equipment(maintenanceOrder.getEquipment().getSerialNumber())
            .employee(maintenanceOrder.getEmployee().getName())
            .orderStatus(maintenanceOrder.getOrderStatus().name())
            .type(maintenanceOrder.getType().name())
            .build();
    }
}
