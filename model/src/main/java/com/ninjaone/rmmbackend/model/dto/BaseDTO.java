package com.ninjaone.rmmbackend.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ninjaone.rmmbackend.model.converter.UUIDConverter;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@ToString
@SuperBuilder
@NoArgsConstructor
public class BaseDTO {

    private String id;

    @JsonIgnore
    public UUID getUUID() {
        return id == null ? null : UUIDConverter.toUUID(id);
    }

}

