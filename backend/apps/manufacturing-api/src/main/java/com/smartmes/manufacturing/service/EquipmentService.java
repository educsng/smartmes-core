package com.smartmes.manufacturing.service;

import com.smartmes.manufacturing.dto.EquipmentResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface EquipmentService {
    Page<EquipmentResponseDto> getEquipments(PageRequest pageRequest);
}
