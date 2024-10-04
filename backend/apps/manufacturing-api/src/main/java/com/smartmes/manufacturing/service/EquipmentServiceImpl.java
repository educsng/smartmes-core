package com.smartmes.manufacturing.service;

import com.smartmes.manufacturing.domain.Equipment;
import com.smartmes.manufacturing.dto.EquipmentResponseDto;
import com.smartmes.manufacturing.mapper.EquipmentMapper;
import com.smartmes.manufacturing.repository.EquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentRepository equipmentRepository;
    private final EquipmentMapper equipmentMapper;

    @Override
    public Page<EquipmentResponseDto> getEquipments(PageRequest pageRequest) {
        Page<Equipment> equipments = equipmentRepository.findAll(pageRequest);

        return equipments.map(equipmentMapper::toResponseDto);
    }
}
