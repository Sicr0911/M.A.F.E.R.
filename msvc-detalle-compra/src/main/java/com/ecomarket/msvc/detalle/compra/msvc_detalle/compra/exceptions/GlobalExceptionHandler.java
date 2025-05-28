package com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.exceptions;

import com.ecomarket.msvc.detalle.compra.msvc_detalle.compra.dtos.ErrorDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.Date;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Se crea metodo privado que permite generar el error DTO con los elementos basicos del error
    private ErrorDTO createErrorDTO(int status, Date date, Map<String, String> errorMap) {
        ErrorDTO errorDTO = new ErrorDTO();

        errorDTO.setStatus(status);
        errorDTO.setDate(date);
        errorDTO.setErrors(errorMap);

        return errorDTO;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleDetalleCompraException(MethodArgumentNotValidException exception) {

        if (exception.getMessage().contains("no se encuentra en la base de datos")) {
            // Esto nos sirve para cuando el detalle no existe en la base de datos
            Map<String, String> errorMap = Collections.singletonMap("Detalle de compra no encontrado", exception.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(this.createErrorDTO(HttpStatus.NOT_FOUND.value(), new Date(), errorMap));
        } else {
            // Esto nos sirve para cuando el detalle ya existe en nuestra base de datos
            Map<String, String> errorMap = Collections.singletonMap("Detalle de compra existente", exception.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(this.createErrorDTO(HttpStatus.CONFLICT.value(), new Date(), errorMap));
        }
    }
}
