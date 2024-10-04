package com.smartmes.maintenance.service.maintenance;

import com.smartmes.maintenance.domain.equipment.Equipment;
import com.smartmes.maintenance.domain.order.MaintenanceOrder;
import com.smartmes.maintenance.domain.order.MaintenanceOrderItem;
import com.smartmes.maintenance.dto.MaintenanceOrderCreationRequestDto;
import com.smartmes.maintenance.dto.MaintenanceOrderCreationResponseDto;
import com.smartmes.maintenance.dto.MaintenanceOrderIncidentRequestDto;
import com.smartmes.maintenance.dto.MaintenanceOrderResponseDto;
import com.smartmes.maintenance.dto.MaintenanceOrderUpdateRequestDto;
import com.smartmes.maintenance.mapper.MaintenanceOrderMapper;
import com.smartmes.maintenance.publisher.IncidentPublisher;
import com.smartmes.maintenance.repository.MaintenanceOrderItemRepository;
import com.smartmes.maintenance.repository.MaintenanceOrderRepository;
import com.smartmes.maintenance.service.employee.EmployeeService;
import com.smartmes.maintenance.service.equipment.EquipmentService;
import com.smartmes.maintenance.validator.MaintenanceOrderValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static com.smartmes.maintenance.enumeration.OrderStatus.FINISHED;
import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class MaintenanceOrderServiceImpl implements MaintenanceOrderService {

    private final MaintenanceOrderRepository maintenanceOrderRepository;
    private final MaintenanceOrderMapper maintenanceOrderMapper;
    private final MaintenanceOrderValidator maintenanceOrderValidator;
    private final IncidentPublisher incidentPublisher;
    private final EquipmentService equipmentService;
    private final MaintenanceOrderItemRepository maintenanceOrderItemRepository;
    private final EmployeeService employeeService;

    @Override
    public Page<MaintenanceOrderResponseDto> getOrders(PageRequest pageRequest) {
        Page<MaintenanceOrder> maintenanceOrders = maintenanceOrderRepository.findAll(pageRequest);

        return maintenanceOrderMapper.toMaintenanceOrderResponseDto(maintenanceOrders);
    }

    @Override
    public void createIncident(MaintenanceOrderIncidentRequestDto requestDto) {
        maintenanceOrderValidator.validateIncidentRequest(requestDto);
        final MaintenanceOrder maintenanceOrder = maintenanceOrderRepository.save(maintenanceOrderMapper.fromMaintenanceOrderIncidentRequestDto(requestDto));

        incidentPublisher.sendToQueue(maintenanceOrder.getId());
    }

    @Override
    @Transactional
    public void updateMaintenanceOrder(Long orderId, MaintenanceOrderUpdateRequestDto requestDto) {
        MaintenanceOrder maintenanceOrder = this.mustFindById(orderId);
        maintenanceOrderValidator.validateOrderStatus(maintenanceOrder);
        List<MaintenanceOrderItem> orderItems = maintenanceOrderMapper.toMaintenanceOrderItems(requestDto.getItems(), maintenanceOrder);
        var savedItems = maintenanceOrderItemRepository.saveAllAndFlush(orderItems);

        maintenanceOrder.setFinishedAt(getFinishedAt(requestDto));
        maintenanceOrder.setOrderStatus(requestDto.getOrderStatus());
        maintenanceOrder.setItems(savedItems);
        maintenanceOrderRepository.save(maintenanceOrder);
    }

    @Override
    @Transactional
    public MaintenanceOrderCreationResponseDto createMaintenanceOrder(MaintenanceOrderCreationRequestDto requestDto) {
        maintenanceOrderValidator.validateCreateMaintenanceOrderRequest(requestDto);

        final Equipment equipment = equipmentService.mustFindById(requestDto.getEquipmentId());
        maintenanceOrderValidator.validateOrderByEquipment(equipment);
        MaintenanceOrder maintenanceOrder = maintenanceOrderMapper.toMaintenanceOrder(requestDto, equipment);

        if (nonNull(requestDto.getEmployeeId())) {
            this.attachTechnicianToOrder(requestDto, maintenanceOrder);
        }
        MaintenanceOrder savedOrder = maintenanceOrderRepository.saveAndFlush(maintenanceOrder);
        maintenanceOrderItemRepository.saveAllAndFlush(maintenanceOrder.getItems());

        return maintenanceOrderMapper.toMaintenanceOrderCreationResponseDto(savedOrder);
    }

    private void attachTechnicianToOrder(MaintenanceOrderCreationRequestDto requestDto, MaintenanceOrder maintenanceOrder) {
        var technician = employeeService.mustFindTechnicianById(requestDto.getEmployeeId());
        var item = MaintenanceOrderItem.builder()
            .employee(technician)
            .maintenanceOrder(maintenanceOrder)
            .build();
        maintenanceOrder.setItems(Collections.singletonList(item));
    }

    private MaintenanceOrder mustFindById(Long id) {
        return maintenanceOrderRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Ordem de manutenção com o identificador informado não encontrado"));
    }

    private static LocalDateTime getFinishedAt(MaintenanceOrderUpdateRequestDto maintenanceOrder) {
        return FINISHED.equals(maintenanceOrder.getOrderStatus()) ? LocalDateTime.now() : null;
    }

}
