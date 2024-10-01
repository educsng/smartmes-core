package com.smartmes.maintenance.service;

import com.smartmes.maintenance.domain.Equipment;
import com.smartmes.maintenance.domain.MaintenanceOrder;
import com.smartmes.maintenance.dto.MaintenanceOrderCreationResponseDto;
import com.smartmes.maintenance.dto.MaintenanceOrderIncidentRequestDto;
import com.smartmes.maintenance.dto.MaintenanceOrderRequestDto;
import com.smartmes.maintenance.dto.MaintenanceOrderResponseDto;
import com.smartmes.maintenance.mapper.MaintenanceOrderMapper;
import com.smartmes.maintenance.publisher.IncidentPublisher;
import com.smartmes.maintenance.repository.EquipmentRepository;
import com.smartmes.maintenance.repository.MaintenanceOrderRepository;
import com.smartmes.maintenance.validator.MaintenanceOrderValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MaintenanceOrderServiceImpl implements MaintenanceOrderService {

    private final MaintenanceOrderRepository maintenanceOrderRepository;
    private final MaintenanceOrderMapper maintenanceOrderMapper;
    private final MaintenanceOrderValidator maintenanceOrderValidator;
    private final EquipmentRepository equipmentRepository;
    private final IncidentPublisher incidentPublisher;

    @Override
    public Page<MaintenanceOrderResponseDto> getOrders() {
        Page<MaintenanceOrder> maintenanceOrders = maintenanceOrderRepository.findAll(Pageable.ofSize(10));

        return maintenanceOrderMapper.toMaintenanceOrderResponseDto(maintenanceOrders);
    }

    @Override
    public void createOrUpdateIncident(MaintenanceOrderIncidentRequestDto requestDto) {
        // TODO - create order based on request
        var orderId = new MaintenanceOrder().getId();
        //  insert into notification event queue
        incidentPublisher.sendToQueue(String.valueOf(orderId));
    }

    @Override
    @Transactional
    public MaintenanceOrderCreationResponseDto createOrUpdateMaintenanceOrder(MaintenanceOrderRequestDto requestDto) {
        maintenanceOrderValidator.validateCreateManufactureOrder(requestDto);

        Optional<MaintenanceOrder> optionalManufactureOrder = maintenanceOrderRepository.findById(requestDto.getOrderId());
        if (optionalManufactureOrder.isPresent()) {
            var order = optionalManufactureOrder.get();
            // TODO - update order AND return response
        }

        final Equipment equipment = equipmentRepository.findById(requestDto.getEquipmentId())
            .orElseThrow(() -> new RuntimeException("O identificador do equipamento não foi encontrado, insira um identificador válido"));

        // TODO - create order, insert into notification event queue AND return response

        return null;
    }


}
