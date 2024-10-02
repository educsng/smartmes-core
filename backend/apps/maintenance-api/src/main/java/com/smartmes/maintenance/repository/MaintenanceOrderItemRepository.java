package com.smartmes.maintenance.repository;

import com.smartmes.maintenance.domain.order.MaintenanceOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceOrderItemRepository extends JpaRepository<MaintenanceOrderItem, Long> {
}
