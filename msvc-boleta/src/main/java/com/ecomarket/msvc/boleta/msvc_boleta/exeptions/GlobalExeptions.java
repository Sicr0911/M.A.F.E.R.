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
public class GlobalExeptions {

    private errorDTO CreateErrorDTO(int status, Date date, Map<String, String> errorMap) {
        errorDTO ErrorDTO = new errorDTO();

        ErrorDTO.setstatus(status);
        ErrorDTO.setdate(date);
        ErrorDTO.seterrors(errorMap);

        return ErrorDTO;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<errorDTO> handleValidatetionFields(MethodArgumentNotValidException exception) {
        Map<String, String> errorMap = new HashMap<>();
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(this.CreateErrorDTO(HttpStatus.BAD_REQUEST.value(), new Date(), errorMap));
    }


    @ExceptionHandler(BoletaExeption.class)
    public ResponseEntity<errorDTO> handleValidationFields(MethodArgumentNotValidException exception) {

        Map<String, String> errorMap = null;
        if (exception.getMessage().contains("no se encuentra en la base de datos")) {
            Map<String, String> ErrorMap = Collections.singletonMap("Boleta no encontrada", exception.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(this.CreateErrorDTO(HttpStatus.NOT_FOUND.value(), new Date(), errorMap));
        } else {
            errorMap = Collections.singletonMap("Boleta existente", exception.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(this.CreateErrorDTO(HttpStatus.CONTINUE.value(), new Date(), errorMap));
        }

    }
























}
