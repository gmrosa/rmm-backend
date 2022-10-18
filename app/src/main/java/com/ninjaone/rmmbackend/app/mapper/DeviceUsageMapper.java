package com.ninjaone.rmmbackend.app.mapper;

import com.ninjaone.rmmbackend.app.repository.CustomerRepository;
import com.ninjaone.rmmbackend.app.repository.DeviceRepository;
import com.ninjaone.rmmbackend.model.dto.DeviceUsageDTO;
import com.ninjaone.rmmbackend.model.entity.DeviceUsageEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeviceUsageMapper extends BaseMapper<DeviceUsageEntity, DeviceUsageDTO> {

    private final CustomerRepository customerRepository;
    private final DeviceRepository deviceRepository;

    @Override
    public DeviceUsageDTO toDTO(DeviceUsageEntity entity) {
        return DeviceUsageDTO.builder()
                .id(entity.getId())
                .customerName(entity.getCustomer().getName())
                .deviceName(entity.getDevice().getName())
                .quantity(entity.getQuantity())
                .build();
    }

    @Override
    public DeviceUsageEntity toEntity(DeviceUsageDTO dto) {
        return DeviceUsageEntity.builder()
                .id(dto.getUUID())
                .customer(customerRepository.findByNameOrFail(dto.getCustomerName()))
                .device(deviceRepository.findByNameOrFail(dto.getDeviceName()))
                .quantity(dto.getQuantity())
                .build();
    }

    @Override
    public DeviceUsageDTO newDTOInstance() {
        return new DeviceUsageDTO();
    }

    @Override
    public DeviceUsageEntity newEntityInstance() {
        return new DeviceUsageEntity();
    }

}
