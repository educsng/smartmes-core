package com.smartmes.manufacturing.service;

import com.smartmes.manufacturing.dto.ManufactureOrderRequestDto;
import com.smartmes.manufacturing.dto.ManufactureOrderResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface ManufactureOrderService {

    ManufactureOrderResponseDto createOrUpdateManufactureOrder(ManufactureOrderRequestDto manufactureOrder);

    Page<ManufactureOrderResponseDto> getManufactureOrders(PageRequest pageRequest);
}
