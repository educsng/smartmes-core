package com.smartmes.maintenance.validator;

import com.smartmes.maintenance.dto.MaintenanceOrderCreationRequestDto;
import com.smartmes.maintenance.dto.MaintenanceOrderIncidentRequestDto;
import com.smartmes.maintenance.repository.MaintenanceOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.smartmes.maintenance.enumeration.OrderStatus.unfinishedStatuses;
import static io.micrometer.common.util.StringUtils.isBlank;
import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class MaintenanceOrderValidator {

    private final MaintenanceOrderRepository maintenanceOrderRepository;

    public void validateCreateMaintenanceOrderRequest(MaintenanceOrderCreationRequestDto requestDto) {
        if (isNull(requestDto.getEmployeeId())) {
            throw new IllegalArgumentException("O campo employeeId é obrigatório");
        }

        if (isNull(requestDto.getEquipmentId())) {
            throw new IllegalArgumentException("O campo equipmentId é obrigatório");
        }

        if (isNull(requestDto.getType())) {
            throw new IllegalArgumentException("O campo type é obrigatório");
        }

        if (isBlank(requestDto.getReason())) {
            throw new IllegalArgumentException("O campo reason é obrigatório");
        }

        if (isNull(requestDto.getPriority())) {
            throw new IllegalArgumentException("O campo priority é obrigatório");
        }
    }

    public void validateIncidentRequest(MaintenanceOrderIncidentRequestDto requestDto) {
        if (maintenanceOrderRepository.existsByEquipmentIdAndOrderStatusIn(requestDto.getEquipmentId(), unfinishedStatuses())) {
            throw new RuntimeException("O equipamento informado já tem uma manutenção em progresso");
        }
    }
}
