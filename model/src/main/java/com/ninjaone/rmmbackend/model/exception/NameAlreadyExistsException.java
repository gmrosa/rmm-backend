package com.ninjaone.rmmbackend.model.exception;

import com.ninjaone.rmmbackend.model.dto.FieldErrorDTO;
import com.ninjaone.rmmbackend.model.util.Generics;
import com.ninjaone.rmmbackend.model.validation.ValidationMessage;

public class NameAlreadyExistsException extends FieldValidationException {

    public NameAlreadyExistsException(Class<?> clazz, String name) {
        super(FieldErrorDTO.builder()
                .field(Generics.getFirstGenericInterfaceType(clazz).getSimpleName() + ".name")
                .message(String.format(ValidationMessage.NAME_ALREADY_EXISTS, Generics.getFirstGenericInterfaceType(clazz).getSimpleName(), name))
                .build());
    }

}
