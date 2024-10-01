package com.smartmes.maintenance.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class IncidentListener {

    @RabbitListener(queues = "${queue.incident.name}")
    public void handleMaintenanceOrderIncident(@Payload String message) {
        System.out.println("Incident created, message: " + message);
    }
}
