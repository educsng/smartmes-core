package com.smartmes.maintenance.enumeration;

import java.util.List;

public enum OrderStatus {
    CREATED, IN_PROGRESS, FINISHED;

    public static List<OrderStatus> unfinishedStatuses() {
        return List.of(CREATED, IN_PROGRESS);
    }
}
