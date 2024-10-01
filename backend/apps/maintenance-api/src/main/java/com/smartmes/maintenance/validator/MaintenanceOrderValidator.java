package com.smartmes.maintenance.validator;

import com.smartmes.maintenance.dto.MaintenanceOrderRequestDto;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class MaintenanceOrderValidator {

    public void validateCreateManufactureOrder(MaintenanceOrderRequestDto requestDto) {
        if (isNull(requestDto.getOrderNumber())) {
            throw new IllegalArgumentException("O campo orderNumber é obrigatório");
        }

        if (isNull(requestDto.getEquipmentId())) {
            throw new IllegalArgumentException("O campo equipmentId é obrigatório");
        }

        if (isNull(requestDto.getItems()) || requestDto.getItems().isEmpty()) {
            throw new IllegalArgumentException("O campo items é obrigatório");
        }
    }
}
