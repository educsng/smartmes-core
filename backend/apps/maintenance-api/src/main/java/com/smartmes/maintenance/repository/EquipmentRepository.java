package com.smartmes.maintenance.repository;

import com.smartmes.maintenance.domain.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
