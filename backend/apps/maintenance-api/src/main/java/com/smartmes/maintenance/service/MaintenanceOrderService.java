package com.smartmes.maintenance.service;

import com.smartmes.maintenance.dto.MaintenanceOrderCreationResponseDto;
import com.smartmes.maintenance.dto.MaintenanceOrderIncidentRequestDto;
import com.smartmes.maintenance.dto.MaintenanceOrderRequestDto;
import com.smartmes.maintenance.dto.MaintenanceOrderResponseDto;
import org.springframework.data.domain.Page;

public interface MaintenanceOrderService {

    MaintenanceOrderCreationResponseDto createOrUpdateMaintenanceOrder(MaintenanceOrderRequestDto manufactureOrder);

    Page<MaintenanceOrderResponseDto> getOrders();

    void createOrUpdateIncident(MaintenanceOrderIncidentRequestDto requestDto);
}
