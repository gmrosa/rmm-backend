package com.ninjaone.rmmbackend.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class FieldErrorDTO extends ErrorDTO {

    private String field;

}
