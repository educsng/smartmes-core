package com.smartmes.maintenance.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class IncidentListener {

    @RabbitListener(queues = "${queue.incident.name}")
    public void handleMaintenanceOrderIncident(@Payload Long orderId) {
        System.out.println("Incident created, message: " + orderId);
        // TODO - notify related users and update order status based on events
    }
}
