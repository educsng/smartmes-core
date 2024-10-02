package com.smartmes.maintenance.mapper;

import com.smartmes.maintenance.domain.equipment.Equipment;
import com.smartmes.maintenance.domain.order.MaintenanceOrder;
import com.smartmes.maintenance.domain.order.MaintenanceOrderItem;
import com.smartmes.maintenance.dto.MaintenanceOrderCreationRequestDto;
import com.smartmes.maintenance.dto.MaintenanceOrderCreationResponseDto;
import com.smartmes.maintenance.dto.MaintenanceOrderIncidentRequestDto;
import com.smartmes.maintenance.dto.MaintenanceOrderItemRequestDto;
import com.smartmes.maintenance.dto.MaintenanceOrderResponseDto;
import com.smartmes.maintenance.enumeration.MaintenanceOrderType;
import com.smartmes.maintenance.enumeration.MaintenancePriority;
import com.smartmes.maintenance.enumeration.OrderStatus;
import com.smartmes.maintenance.service.employee.EmployeeService;
import com.smartmes.maintenance.service.equipment.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MaintenanceOrderMapper {

    private final EmployeeService employeeService;
    private final EquipmentService equipmentService;

    public Page<MaintenanceOrderResponseDto> toMaintenanceOrderResponseDto(Page<MaintenanceOrder> maintenanceOrders) {
        return maintenanceOrders.map(MaintenanceOrderMapper::fromMaintenanceOrder);
    }

    public MaintenanceOrder toMaintenanceOrder(MaintenanceOrderCreationRequestDto requestDto, Equipment equipment) {
        return MaintenanceOrder.builder()
            .reason(requestDto.getReason())
            .orderStatus(OrderStatus.CREATED)
            .equipment(equipment)
            .type(requestDto.getType())
            .priority(requestDto.getPriority())
            .createdAt(LocalDateTime.now())
            .build();
    }

    public MaintenanceOrder fromMaintenanceOrderIncidentRequestDto(MaintenanceOrderIncidentRequestDto requestDto) {
        return MaintenanceOrder.builder()
            .reason(requestDto.getReason())
            .equipment(equipmentService.mustFindById(requestDto.getEquipmentId()))
            .orderStatus(OrderStatus.CREATED)
            .type(MaintenanceOrderType.INCIDENT)
            .priority(MaintenancePriority.HIGH)
            .createdAt(LocalDateTime.now())
            .build();
    }

    public MaintenanceOrderCreationResponseDto toMaintenanceOrderCreationResponseDto(MaintenanceOrder maintenanceOrder) {
        return MaintenanceOrderCreationResponseDto.builder()
            .message("Ordem de manutenção criada com sucesso.")
            .manufactureOrder(fromMaintenanceOrder(maintenanceOrder))
            .build();
    }

    private static MaintenanceOrderResponseDto fromMaintenanceOrder(MaintenanceOrder maintenanceOrder) {
        return MaintenanceOrderResponseDto.builder()
            .id(maintenanceOrder.getId())
            .reason(maintenanceOrder.getReason())
            .createdAt(maintenanceOrder.getCreatedAt())
            .equipment(maintenanceOrder.getEquipment().getSerialNumber())
            .orderStatus(maintenanceOrder.getOrderStatus().name())
            .type(maintenanceOrder.getType().name())
            .build();
    }

    public List<MaintenanceOrderItem> toMaintenanceOrderItems(List<MaintenanceOrderItemRequestDto> items, MaintenanceOrder maintenanceOrder) {
        return items.stream()
            .map(item -> toMaintenanceOrderItem(item, maintenanceOrder))
            .toList();
    }

    private MaintenanceOrderItem toMaintenanceOrderItem(MaintenanceOrderItemRequestDto maintenanceOrderItemRequestDto, MaintenanceOrder maintenanceOrder) {
        return MaintenanceOrderItem.builder()
            .description(maintenanceOrderItemRequestDto.getDescription())
            .employee(employeeService.mustFindTechnicianById(maintenanceOrderItemRequestDto.getEmployeeId()))
            .startedAt(LocalDateTime.now())
            .shift(maintenanceOrderItemRequestDto.getShift())
            .maintenanceOrder(maintenanceOrder)
            .build();
    }
}
