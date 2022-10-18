package com.ninjaone.rmmbackend.app.mapper;

import com.ninjaone.rmmbackend.model.converter.UUIDConverter;
import com.ninjaone.rmmbackend.model.dto.DeviceTypeDTO;
import com.ninjaone.rmmbackend.model.entity.DeviceTypeEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class DeviceTypeMapperTest {

    @InjectMocks
    private DeviceTypeMapper mapper;

    @Test
    public void shouldConvertToDTO() {
        UUID uuid = UUID.randomUUID();
        String name = "DeviceType1";
        DeviceTypeEntity deviceType = DeviceTypeEntity.builder().id(uuid).name(name).build();

        DeviceTypeDTO actual = mapper.toDTO(deviceType);
        DeviceTypeDTO expected = DeviceTypeDTO.builder().id(UUIDConverter.toString(uuid)).name(name).build();

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldConvertToEntity() {
        UUID uuid = UUID.randomUUID();
        String name = "DeviceType1";

        DeviceTypeDTO dto = DeviceTypeDTO.builder().id(UUIDConverter.toString(uuid)).name(name).build();

        DeviceTypeEntity actual = mapper.toEntity(dto);
        DeviceTypeEntity expected = DeviceTypeEntity.builder().id(uuid).name(name).build();

        Assertions.assertThat(actual).isEqualTo(expected);
    }

}
