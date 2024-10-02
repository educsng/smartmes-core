package com.smartmes.maintenance.config;

import com.smartmes.maintenance.dto.ExceptionResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {IllegalArgumentException.class, RuntimeException.class})
    public ResponseEntity<ExceptionResponseDto> handleBadRequestExceptions(final Exception exception, final WebRequest request) {
        log.error(exception.getMessage(), exception);
        return ResponseEntity.status(400).body(buildResponseDto(exception, request));
    }

    private static ExceptionResponseDto buildResponseDto(Exception exception, WebRequest request) {
        return ExceptionResponseDto.builder()
            .status(400)
            .error(exception.getMessage())
            .timestamp(LocalDateTime.now().toString())
            .path(request.getDescription(false))
            .build();
    }

}
