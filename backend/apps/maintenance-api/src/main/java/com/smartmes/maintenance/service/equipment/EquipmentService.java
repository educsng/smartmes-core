package com.smartmes.maintenance.service.equipment;

import com.smartmes.maintenance.domain.equipment.Equipment;

public interface EquipmentService {

    Equipment mustFindById(Long equipmentId);
}
