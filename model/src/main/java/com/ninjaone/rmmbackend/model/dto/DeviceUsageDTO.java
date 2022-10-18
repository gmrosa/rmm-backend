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
public class DeviceUsageDTO extends BaseDTO {

    @NotEmpty(message = ValidationMessage.REQUIRED_FIELD)
    private String customerName;
    @NotEmpty(message = ValidationMessage.REQUIRED_FIELD)
    private String deviceName;
    @NotNull(message = ValidationMessage.REQUIRED_FIELD)
    private Integer quantity;

}
