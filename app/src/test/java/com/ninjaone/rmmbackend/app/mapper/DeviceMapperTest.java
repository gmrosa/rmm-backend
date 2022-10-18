package com.ninjaone.rmmbackend.app.mapper;

import com.ninjaone.rmmbackend.app.repository.DeviceTypeRepository;
import com.ninjaone.rmmbackend.model.converter.UUIDConverter;
import com.ninjaone.rmmbackend.model.dto.DeviceDTO;
import com.ninjaone.rmmbackend.model.entity.DeviceEntity;
import com.ninjaone.rmmbackend.model.entity.DeviceTypeEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class DeviceMapperTest {

    @Mock
    private DeviceTypeRepository deviceTypeRepository;
    @InjectMocks
    private DeviceMapper mapper;

    @Test
    public void shouldConvertToDTO() {
        UUID uuid = UUID.randomUUID();
        String name = "Device1";
        String deviceTypeName = "MAC";
        DeviceEntity device = DeviceEntity.builder()
                .id(uuid)
                .name(name)
                .deviceType(DeviceTypeEntity.builder().id(UUID.randomUUID()).name(deviceTypeName).build())
                .build();

        DeviceDTO actual = mapper.toDTO(device);
        DeviceDTO expected = DeviceDTO.builder()
                .id(UUIDConverter.toString(uuid)).name(name)
                .deviceType(deviceTypeName)
                .build();

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldConvertToEntity() {
        UUID uuid = UUID.randomUUID();
        String name = "Device1";
        String deviceTypeName = "MAC";

        DeviceDTO dto = DeviceDTO.builder().id(UUIDConverter.toString(uuid)).name(name).deviceType(deviceTypeName).build();
        DeviceTypeEntity deviceType = DeviceTypeEntity.builder().id(UUID.randomUUID()).name(deviceTypeName).build();

        Mockito.when(deviceTypeRepository.findByNameOrFail(deviceTypeName)).thenReturn(deviceType);

        DeviceEntity actual = mapper.toEntity(dto);
        DeviceEntity expected = DeviceEntity.builder()
                .id(uuid)
                .name(name)
                .deviceType(deviceType)
                .build();

        Assertions.assertThat(actual).isEqualTo(expected);
    }

}
