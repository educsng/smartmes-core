package com.smartmes.maintenance.controller;

import com.smartmes.maintenance.dto.MaintenanceOrderCreationRequestDto;
import com.smartmes.maintenance.dto.MaintenanceOrderCreationResponseDto;
import com.smartmes.maintenance.dto.MaintenanceOrderIncidentRequestDto;
import com.smartmes.maintenance.dto.MaintenanceOrderResponseDto;
import com.smartmes.maintenance.dto.MaintenanceOrderUpdateRequestDto;
import com.smartmes.maintenance.service.maintenance.MaintenanceOrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/maintenance-orders")
public class MaintenanceOrderController {

    private final MaintenanceOrderService maintenanceOrderService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<MaintenanceOrderResponseDto> getOrders(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        var sort = Sort.by(Sort.Direction.ASC, "createdAt");
        return maintenanceOrderService.getOrders(PageRequest.of(page, size, sort));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MaintenanceOrderCreationResponseDto createMaintenanceOrder(@Valid @RequestBody MaintenanceOrderCreationRequestDto requestDto) {
        return maintenanceOrderService.createMaintenanceOrder(requestDto);
    }

    @PutMapping("/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateMaintenanceOrder(
        @PathVariable("orderId") Long orderId,
        @Valid @RequestBody MaintenanceOrderUpdateRequestDto requestDto
    ) {
        maintenanceOrderService.updateMaintenanceOrder(orderId, requestDto);
    }

    @PostMapping("/incident")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void createIncident(@Valid @RequestBody MaintenanceOrderIncidentRequestDto requestDto) {
        maintenanceOrderService.createIncident(requestDto);
    }
}
