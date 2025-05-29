package com.ecomarket.msvc.boleta.msvc_boleta.exeptions;

import com.ecomarket.msvc.boleta.msvc_boleta.dtos.errorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Se crea metodo privado que permite generar el error DTO con los elementos basicos del error
    private errorDTO createErrorDTO(int status, Date date, Map<String, String> errorMap) {
        errorDTO errorDTO = new errorDTO();

        errorDTO.setStatus(status);
        errorDTO.setDate(date);
        errorDTO.setErrors(errorMap);

        return errorDTO;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<errorDTO> handleValidationFields(MethodArgumentNotValidException exception) {
        Map<String, String> errorMap = new HashMap<>();
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(this.createErrorDTO(HttpStatus.BAD_REQUEST.value(), new Date(), errorMap));
    }

    @ExceptionHandler(BoletaExeption.class)
    public ResponseEntity<errorDTO> handleInventarioException(BoletaExeption exception) {

        if (exception.getMessage().contains("no se encuentra en la base de datos")) {
            // Esto nos sirve para cuando el detalle no existe en la base de datos
            Map<String, String> errorMap = Collections.singletonMap("Inventario no encontrado", exception.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(this.createErrorDTO(HttpStatus.NOT_FOUND.value(), new Date(), errorMap));
        } else {
            // Esto nos sirve para cuando el detalle ya existe en nuestra base de datos
            Map<String, String> errorMap = Collections.singletonMap("Inventario existente", exception.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(this.createErrorDTO(HttpStatus.CONFLICT.value(), new Date(), errorMap));
        }
    }
}
