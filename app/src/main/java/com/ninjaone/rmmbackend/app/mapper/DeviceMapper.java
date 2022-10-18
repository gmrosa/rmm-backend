package com.ninjaone.rmmbackend.app.mapper;

import com.ninjaone.rmmbackend.app.repository.DeviceTypeRepository;
import com.ninjaone.rmmbackend.model.dto.DeviceDTO;
import com.ninjaone.rmmbackend.model.entity.DeviceEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeviceMapper extends BaseMapper<DeviceEntity, DeviceDTO> {

    private final DeviceTypeRepository deviceTypeRepository;

    @Override
    public DeviceDTO toDTO(DeviceEntity entity) {
        return DeviceDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .deviceType(entity.getDeviceType().getName())
                .build();
    }

    @Override
    public DeviceEntity toEntity(DeviceDTO dto) {
        return DeviceEntity.builder()
                .id(dto.getUUID())
                .name(dto.getName())
                .deviceType(deviceTypeRepository.findByNameOrFail(dto.getDeviceType())).build();
    }

    @Override
    public DeviceDTO newDTOInstance() {
        return new DeviceDTO();
    }

    @Override
    public DeviceEntity newEntityInstance() {
        return new DeviceEntity();
    }

}
