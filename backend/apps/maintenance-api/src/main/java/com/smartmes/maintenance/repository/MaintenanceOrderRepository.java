package com.smartmes.maintenance.repository;

import com.smartmes.maintenance.domain.MaintenanceOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceOrderRepository extends JpaRepository<MaintenanceOrder, Long> {
}
