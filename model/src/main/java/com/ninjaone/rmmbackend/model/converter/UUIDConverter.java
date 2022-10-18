package com.ninjaone.rmmbackend.model.converter;

import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class UUIDConverter {

    public static UUID toUUID(String id) {
        return UUID.fromString(
                id.replaceFirst("(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)", "$1-$2-$3-$4-$5")
        );
    }

    public static String toString(UUID id) {
        return id.toString().replace("-", "");
    }

}
