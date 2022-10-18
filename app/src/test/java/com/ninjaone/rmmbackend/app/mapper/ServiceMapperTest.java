package com.ninjaone.rmmbackend.app.mapper;

import com.ninjaone.rmmbackend.app.repository.DeviceTypeRepository;
import com.ninjaone.rmmbackend.app.repository.ServiceTypeRepository;
import com.ninjaone.rmmbackend.model.converter.UUIDConverter;
import com.ninjaone.rmmbackend.model.dto.ServiceDTO;
import com.ninjaone.rmmbackend.model.entity.DeviceTypeEntity;
import com.ninjaone.rmmbackend.model.entity.ServiceEntity;
import com.ninjaone.rmmbackend.model.entity.ServiceTypeEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class ServiceMapperTest {

    @Mock
    private DeviceTypeRepository deviceTypeRepository;
    @Mock
    private ServiceTypeRepository serviceTypeRepository;
    @InjectMocks
    private ServiceMapper mapper;

    @Test
    public void shouldConvertToDTO() {
        UUID uuid = UUID.randomUUID();
        String deviceTypeName = "DeviceType1";
        String serviceTypeName = "ServiceType1";
        DeviceTypeEntity deviceType = DeviceTypeEntity.builder().id(UUID.randomUUID()).name(deviceTypeName).build();
        ServiceTypeEntity serviceType = ServiceTypeEntity.builder().id(UUID.randomUUID()).name(serviceTypeName).build();
        Float price = 5F;

        ServiceEntity service = ServiceEntity.builder()
                .id(uuid)
                .deviceType(deviceType)
                .serviceType(serviceType)
                .price(price)
                .build();

        ServiceDTO actual = mapper.toDTO(service);
        ServiceDTO expected = ServiceDTO.builder()
                .id(UUIDConverter.toString(uuid))
                .deviceTypeName(deviceTypeName)
                .serviceTypeName(serviceTypeName)
                .price(price)
                .build();

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldConvertToEntity() {
        UUID uuid = UUID.randomUUID();
        String deviceTypeName = "DeviceType1";
        String serviceTypeName = "ServiceType1";
        DeviceTypeEntity deviceType = DeviceTypeEntity.builder().id(UUID.randomUUID()).name(deviceTypeName).build();
        ServiceTypeEntity serviceType = ServiceTypeEntity.builder().id(UUID.randomUUID()).name(serviceTypeName).build();
        Float price = 5F;

        ServiceDTO dto = ServiceDTO.builder()
                .id(UUIDConverter.toString(uuid))
                .deviceTypeName(deviceTypeName)
                .serviceTypeName(serviceTypeName)
                .price(price)
                .build();

        Mockito.when(deviceTypeRepository.findByNameOrFail(deviceTypeName)).thenReturn(deviceType);
        Mockito.when(serviceTypeRepository.findByNameOrFail(serviceTypeName)).thenReturn(serviceType);

        ServiceEntity actual = mapper.toEntity(dto);
        ServiceEntity expected = ServiceEntity.builder()
                .id(uuid)
                .deviceType(deviceType)
                .serviceType(serviceType)
                .price(price)
                .build();

        Assertions.assertThat(actual).isEqualTo(expected);
    }

}
