package com.smartmes.manufacturing.mapper;

import com.smartmes.manufacturing.domain.Equipment;
import com.smartmes.manufacturing.dto.EquipmentResponseDto;
import org.springframework.stereotype.Component;

@Component
public class EquipmentMapper {
    public EquipmentResponseDto toResponseDto(Equipment equipment) {
        return EquipmentResponseDto.builder()
            .id(equipment.getId())
            .name(equipment.getDescription())
            .build();
    }
}
