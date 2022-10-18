package com.ninjaone.rmmbackend.model.dto;

import com.ninjaone.rmmbackend.model.validation.ValidationMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotEmpty;

@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ServiceUsageDTO extends BaseDTO {

    @NotEmpty(message = ValidationMessage.REQUIRED_FIELD)
    private String deviceUsageId;
    @NotEmpty(message = ValidationMessage.REQUIRED_FIELD)
    private String serviceId;

}
