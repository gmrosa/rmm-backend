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
public class DeviceDTO extends NameDTO {

    @NotEmpty(message = ValidationMessage.REQUIRED_FIELD)
    private String deviceType;

}
