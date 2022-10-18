package com.ninjaone.rmmbackend.model.exception;

import com.ninjaone.rmmbackend.model.dto.FieldErrorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FieldValidationException extends BadRequestException {

    private FieldErrorDTO dto;

}
