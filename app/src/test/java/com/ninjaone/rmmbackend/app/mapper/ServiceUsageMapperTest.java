package com.ninjaone.rmmbackend.app.mapper;

import com.ninjaone.rmmbackend.app.repository.DeviceUsageRepository;
import com.ninjaone.rmmbackend.app.repository.ServiceRepository;
import com.ninjaone.rmmbackend.model.converter.UUIDConverter;
import com.ninjaone.rmmbackend.model.dto.ServiceUsageDTO;
import com.ninjaone.rmmbackend.model.entity.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class ServiceUsageMapperTest {

    @Mock
    private DeviceUsageRepository deviceUsageRepository;
    @Mock
    private ServiceRepository serviceRepository;
    @InjectMocks
    private ServiceUsageMapper mapper;

    @Test
    public void shouldConvertToDTO() {
        UUID uuid = UUID.randomUUID();
        Integer quantity = 5;
        String customerName = "Customer1";
        String deviceName = "Device1";

        CustomerEntity customer = CustomerEntity.builder().id(UUID.randomUUID()).name(customerName).build();
        DeviceEntity device = DeviceEntity.builder().id(UUID.randomUUID()).name(deviceName).build();

        DeviceUsageEntity deviceUsage = DeviceUsageEntity.builder()
                .id(UUID.randomUUID())
                .customer(customer)
                .device(device)
                .quantity(quantity)
                .build();

        String deviceTypeName = "DeviceType1";
        String serviceTypeName = "ServiceType1";
        DeviceTypeEntity deviceType = DeviceTypeEntity.builder().id(UUID.randomUUID()).name(deviceTypeName).build();
        ServiceTypeEntity serviceType = ServiceTypeEntity.builder().id(UUID.randomUUID()).name(serviceTypeName).build();
        Float price = 5F;

        ServiceEntity service = ServiceEntity.builder()
                .id(UUID.randomUUID())
                .deviceType(deviceType)
                .serviceType(serviceType)
                .price(price)
                .build();

        ServiceUsageEntity serviceUsageEntity = ServiceUsageEntity.builder().id(uuid).deviceUsage(deviceUsage).service(service).build();

        ServiceUsageDTO actual = mapper.toDTO(serviceUsageEntity);
        ServiceUsageDTO expected = ServiceUsageDTO.builder()
                .id(UUIDConverter.toString(uuid))
                .deviceUsageId(deviceUsage.getId())
                .serviceId(service.getId())
                .build();

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldConvertToEntity() {
        UUID uuid = UUID.randomUUID();
        Integer quantity = 5;
        String customerName = "Customer1";
        String deviceName = "Device1";

        CustomerEntity customer = CustomerEntity.builder().id(UUID.randomUUID()).name(customerName).build();
        DeviceEntity device = DeviceEntity.builder().id(UUID.randomUUID()).name(deviceName).build();

        DeviceUsageEntity deviceUsage = DeviceUsageEntity.builder()
                .id(UUID.randomUUID())
                .customer(customer)
                .device(device)
                .quantity(quantity)
                .build();

        String deviceTypeName = "DeviceType1";
        String serviceTypeName = "ServiceType1";
        DeviceTypeEntity deviceType = DeviceTypeEntity.builder().id(UUID.randomUUID()).name(deviceTypeName).build();
        ServiceTypeEntity serviceType = ServiceTypeEntity.builder().id(UUID.randomUUID()).name(serviceTypeName).build();
        Float price = 5F;

        ServiceEntity service = ServiceEntity.builder()
                .id(UUID.randomUUID())
                .deviceType(deviceType)
                .serviceType(serviceType)
                .price(price)
                .build();

        ServiceUsageDTO dto = ServiceUsageDTO.builder()
                .id(UUIDConverter.toString(uuid))
                .deviceUsageId(deviceUsage.getId())
                .serviceId(service.getId())
                .build();

        Mockito.when(deviceUsageRepository.findByIdOrFail(deviceUsage.getId())).thenReturn(deviceUsage);
        Mockito.when(serviceRepository.findByIdOrFail(service.getId())).thenReturn(service);

        ServiceUsageEntity actual = mapper.toEntity(dto);
        ServiceUsageEntity expected = ServiceUsageEntity.builder().id(uuid).deviceUsage(deviceUsage).service(service).build();

        Assertions.assertThat(actual).isEqualTo(expected);
    }

}
