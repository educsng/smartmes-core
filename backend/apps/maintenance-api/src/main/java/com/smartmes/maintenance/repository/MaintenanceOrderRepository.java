package com.smartmes.maintenance.repository;

import com.smartmes.maintenance.domain.order.MaintenanceOrder;
import com.smartmes.maintenance.enumeration.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaintenanceOrderRepository extends JpaRepository<MaintenanceOrder, Long> {
    boolean existsByEquipmentIdAndOrderStatusIn(Long equipmentId, List<OrderStatus> orderStatus);
}
