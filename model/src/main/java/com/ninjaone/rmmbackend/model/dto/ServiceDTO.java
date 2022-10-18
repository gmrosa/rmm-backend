package com.ninjaone.rmmbackend.model.dto;

import com.ninjaone.rmmbackend.model.validation.ValidationMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ServiceDTO extends BaseDTO {

    @NotEmpty(message = ValidationMessage.REQUIRED_FIELD)
    private String serviceTypeName;
    private String deviceTypeName;
    @NotNull(message = ValidationMessage.REQUIRED_FIELD)
    private Float price;

}
