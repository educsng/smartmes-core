package com.smartmes.maintenance.service.maintenance;

import com.smartmes.maintenance.dto.MaintenanceOrderCreationRequestDto;
import com.smartmes.maintenance.dto.MaintenanceOrderCreationResponseDto;
import com.smartmes.maintenance.dto.MaintenanceOrderIncidentRequestDto;
import com.smartmes.maintenance.dto.MaintenanceOrderResponseDto;
import com.smartmes.maintenance.dto.MaintenanceOrderUpdateRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface MaintenanceOrderService {

    MaintenanceOrderCreationResponseDto createMaintenanceOrder(MaintenanceOrderCreationRequestDto manufactureOrder);

    Page<MaintenanceOrderResponseDto> getOrders(PageRequest pageRequest);

    void createIncident(MaintenanceOrderIncidentRequestDto requestDto);

    void updateMaintenanceOrder(Long orderId, MaintenanceOrderUpdateRequestDto requestDto);
}
