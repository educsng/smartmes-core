package com.smartmes.maintenance.controller;

import com.smartmes.maintenance.dto.MaintenanceOrderIncidentRequestDto;
import com.smartmes.maintenance.dto.MaintenanceOrderRequestDto;
import com.smartmes.maintenance.dto.MaintenanceOrderCreationResponseDto;
import com.smartmes.maintenance.dto.MaintenanceOrderResponseDto;
import com.smartmes.maintenance.service.MaintenanceOrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/maintenance-orders")
public class MaintenanceOrderController {

    private final MaintenanceOrderService maintenanceOrderService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<MaintenanceOrderResponseDto> getOrders() {
        return maintenanceOrderService.getOrders();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MaintenanceOrderCreationResponseDto createOrUpdateMaintenanceOrder(@Valid @RequestBody MaintenanceOrderRequestDto requestDto) {
        return maintenanceOrderService.createOrUpdateMaintenanceOrder(requestDto);
    }

    @PostMapping("/incident")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void createOrUpdateIncident(@Valid @RequestBody MaintenanceOrderIncidentRequestDto requestDto) {
        maintenanceOrderService.createOrUpdateIncident(requestDto);
    }
}
