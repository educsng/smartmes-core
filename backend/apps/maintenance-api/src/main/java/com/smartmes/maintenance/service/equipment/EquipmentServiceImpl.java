package com.smartmes.maintenance.service.equipment;

import com.smartmes.maintenance.domain.Equipment;
import com.smartmes.maintenance.repository.EquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentRepository equipmentRepository;

    @Override
    public Equipment mustFindById(Long equipmentId) {
        return this.findById(equipmentId)
            .orElseThrow(() -> new RuntimeException("O identificador do equipamento não foi encontrado, insira um identificador válido"));
    }

    private Optional<Equipment> findById(Long equipmentId) {
        return equipmentRepository.findById(equipmentId);
    }
}
