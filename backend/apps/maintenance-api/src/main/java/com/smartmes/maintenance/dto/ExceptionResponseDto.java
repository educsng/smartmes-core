package com.smartmes.maintenance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponseDto {
    @Builder.Default
    private String timestamp = LocalDateTime.now().toString();
    private int status;
    private String error;
    private String path;
}
