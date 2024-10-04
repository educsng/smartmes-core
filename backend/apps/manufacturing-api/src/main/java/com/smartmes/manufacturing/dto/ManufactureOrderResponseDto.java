package com.smartmes.manufacturing.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ManufactureOrderResponseDto {

    private String message;
    private ManufactureOrderResponse manufactureOrder;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ManufactureOrderResponse {
        private Long id;
        private String orderNumber;
        private String description;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
        private LocalDateTime createdAt;
        private String equipment;
        private String employee;
        private String orderStatus;
        private List<ManufactureOrderItemResponseDto> items;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ManufactureOrderItemResponseDto {
        private Long id;
        private String description;
        private Integer quantity;
        private Integer nonConformingQuantity;
        private String unit;
        private String shift;
    }
}
