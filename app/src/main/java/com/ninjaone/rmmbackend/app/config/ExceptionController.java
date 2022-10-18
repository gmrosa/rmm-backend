package com.ninjaone.rmmbackend.app.config;

import com.ninjaone.rmmbackend.model.dto.ErrorDTO;
import com.ninjaone.rmmbackend.model.dto.FieldErrorDTO;
import com.ninjaone.rmmbackend.model.exception.BadRequestException;
import com.ninjaone.rmmbackend.model.exception.FieldValidationException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> handleException(Exception e) {
        if (e instanceof BadRequestException) {
            HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

            if (e instanceof FieldValidationException) {
                FieldErrorDTO dto = ((FieldValidationException) e).getDto();
                LOGGER.error(dto.toString());
                return new ResponseEntity<>(dto, httpStatus);
            }
            return new ResponseEntity<>(ErrorDTO.build(e), httpStatus);
        }
        e.printStackTrace();
        LOGGER.error(e.getMessage());
        return new ResponseEntity<>(ErrorDTO.build(e), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<FieldErrorDTO> validationList = ex.getBindingResult().getFieldErrors().stream()
                .map(getFieldErrorMapper())
                .collect(Collectors.toList());
        LOGGER.info("Validation errors: " + validationList);
        return new ResponseEntity<>(validationList, status);
    }

    private static Function<FieldError, FieldErrorDTO> getFieldErrorMapper() {
        return fieldError -> FieldErrorDTO.builder()
                .field(StringUtils.capitalize(fieldError.getObjectName()) + "." + fieldError.getField())
                .message(fieldError.getDefaultMessage())
                .build();
    }

}
