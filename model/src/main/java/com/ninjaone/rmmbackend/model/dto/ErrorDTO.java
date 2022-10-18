package com.ninjaone.rmmbackend.model.dto;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@ToString
@SuperBuilder
public class ErrorDTO {

    private String message;

    public static ErrorDTO build(Exception e) {
        return builder().message(e.getMessage()).build();
    }

}
