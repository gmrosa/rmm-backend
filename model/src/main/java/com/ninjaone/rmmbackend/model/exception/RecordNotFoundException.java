package com.ninjaone.rmmbackend.model.exception;

import com.ninjaone.rmmbackend.model.converter.UUIDConverter;
import com.ninjaone.rmmbackend.model.dto.FieldErrorDTO;
import com.ninjaone.rmmbackend.model.util.Generics;
import com.ninjaone.rmmbackend.model.validation.ValidationMessage;

import java.util.UUID;

public class RecordNotFoundException extends FieldValidationException {

    public RecordNotFoundException(Class<?> clazz, UUID id) {
        this(clazz, "id", UUIDConverter.toString(id), ValidationMessage.ID_NOT_FOUND);
    }

    public RecordNotFoundException(Class<?> clazz, String name) {
        this(clazz, "name", name, ValidationMessage.NAME_NOT_FOUND);
    }

    private RecordNotFoundException(Class<?> clazz, String field, String name, String message) {
        super(FieldErrorDTO.builder()
                .field(Generics.getFirstGenericInterfaceType(clazz).getSimpleName() + "." + field)
                .message(String.format(message, Generics.getFirstGenericInterfaceType(clazz).getSimpleName(), name))
                .build());
    }

}
