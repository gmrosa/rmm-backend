package com.ninjaone.rmmbackend.model.converter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class UUIDConverterTest {

    @Test
    public void shouldConvertToString() {
        UUID uuid = UUID.randomUUID();
        String id = UUIDConverter.toString(uuid);

        Assertions.assertThat(id).isEqualTo(uuid.toString().replace("-", ""));
    }

    @Test
    public void shouldConvertUUID() {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString().replace("-", "");

        Assertions.assertThat(UUIDConverter.toUUID(id)).isEqualTo(uuid);
    }

}
