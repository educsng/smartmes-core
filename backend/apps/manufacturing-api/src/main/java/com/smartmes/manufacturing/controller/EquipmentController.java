package com.smartmes.manufacturing.controller;

import com.smartmes.manufacturing.dto.EquipmentResponseDto;
import com.smartmes.manufacturing.service.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/equipments")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;

    @GetMapping
    public Page<EquipmentResponseDto> getEquipments(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        var sort = Sort.by(Sort.Direction.ASC, "id");
        return equipmentService.getEquipments(PageRequest.of(page, size, sort));
    }
}
