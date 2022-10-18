package com.ninjaone.rmmbackend.app.mapper;

import com.ninjaone.rmmbackend.app.repository.DeviceUsageRepository;
import com.ninjaone.rmmbackend.app.repository.ServiceRepository;
import com.ninjaone.rmmbackend.model.dto.ServiceUsageDTO;
import com.ninjaone.rmmbackend.model.entity.ServiceUsageEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ServiceUsageMapper extends BaseMapper<ServiceUsageEntity, ServiceUsageDTO> {

    private final DeviceUsageRepository deviceUsageRepository;
    private final ServiceRepository serviceRepository;

    @Override
    public ServiceUsageDTO toDTO(ServiceUsageEntity entity) {
        return ServiceUsageDTO.builder()
                .id(entity.getId())
                .deviceUsageId(entity.getDeviceUsage().getId())
                .serviceId(entity.getService().getId())
                .build();
    }

    @Override
    public ServiceUsageEntity toEntity(ServiceUsageDTO dto) {
        return ServiceUsageEntity.builder()
                .id(dto.getUUID())
                .deviceUsage(deviceUsageRepository.findByIdOrFail(dto.getDeviceUsageId()))
                .service(serviceRepository.findByIdOrFail(dto.getServiceId()))
                .build();
    }

    @Override
    public ServiceUsageDTO newDTOInstance() {
        return new ServiceUsageDTO();
    }

    @Override
    public ServiceUsageEntity newEntityInstance() {
        return new ServiceUsageEntity();
    }

}
