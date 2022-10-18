package com.ninjaone.rmmbackend.app.mapper;

import com.ninjaone.rmmbackend.app.repository.CustomerRepository;
import com.ninjaone.rmmbackend.app.repository.DeviceRepository;
import com.ninjaone.rmmbackend.model.converter.UUIDConverter;
import com.ninjaone.rmmbackend.model.dto.DeviceUsageDTO;
import com.ninjaone.rmmbackend.model.entity.CustomerEntity;
import com.ninjaone.rmmbackend.model.entity.DeviceEntity;
import com.ninjaone.rmmbackend.model.entity.DeviceUsageEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class DeviceUsageMapperTest {

    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private DeviceRepository deviceRepository;
    @InjectMocks
    private DeviceUsageMapper mapper;

    @Test
    public void shouldConvertToDTO() {
        UUID uuid = UUID.randomUUID();
        Integer quantity = 5;
        String customerName = "Customer1";
        String deviceName = "Device1";

        CustomerEntity customer = CustomerEntity.builder().id(UUID.randomUUID()).name(customerName).build();
        DeviceEntity device = DeviceEntity.builder().id(UUID.randomUUID()).name(deviceName).build();

        DeviceUsageEntity deviceUsage = DeviceUsageEntity.builder()
                .id(uuid)
                .customer(customer)
                .device(device)
                .quantity(quantity)
                .build();

        DeviceUsageDTO actual = mapper.toDTO(deviceUsage);
        DeviceUsageDTO expected = DeviceUsageDTO.builder()
                .id(UUIDConverter.toString(uuid))
                .customerName(customerName)
                .deviceName(deviceName)
                .quantity(quantity)
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

        DeviceUsageDTO dto = DeviceUsageDTO.builder()
                .id(UUIDConverter.toString(uuid))
                .customerName(customerName)
                .deviceName(deviceName)
                .quantity(quantity)
                .build();

        Mockito.when(customerRepository.findByNameOrFail(customerName)).thenReturn(customer);
        Mockito.when(deviceRepository.findByNameOrFail(deviceName)).thenReturn(device);

        DeviceUsageEntity actual = mapper.toEntity(dto);
        DeviceUsageEntity expected = DeviceUsageEntity.builder()
                .id(uuid)
                .customer(customer)
                .device(device)
                .quantity(quantity)
                .build();

        Assertions.assertThat(actual).isEqualTo(expected);
    }

}
