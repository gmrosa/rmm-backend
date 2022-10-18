package com.ninjaone.rmmbackend.app.mapper;

import com.ninjaone.rmmbackend.app.repository.DeviceTypeRepository;
import com.ninjaone.rmmbackend.app.repository.ServiceTypeRepository;
import com.ninjaone.rmmbackend.model.dto.ServiceDTO;
import com.ninjaone.rmmbackend.model.entity.ServiceEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ServiceMapper extends BaseMapper<ServiceEntity, ServiceDTO> {

    private final ServiceTypeRepository serviceTypeRepository;
    private final DeviceTypeRepository deviceTypeRepository;

    @Override
    public ServiceDTO toDTO(ServiceEntity entity) {
        return ServiceDTO.builder()
                .id(entity.getId())
                .serviceTypeName(entity.getServiceType().getName())
                .deviceTypeName(entity.getDeviceType() == null ? null : entity.getDeviceType().getName())
                .price(entity.getPrice())
                .build();
    }

    @Override
    public ServiceEntity toEntity(ServiceDTO dto) {
        return ServiceEntity.builder()
                .id(dto.getUUID())
                .serviceType(serviceTypeRepository.findByNameOrFail(dto.getServiceTypeName()))
                .deviceType(dto.getDeviceTypeName() == null ? null : deviceTypeRepository.findByNameOrFail(dto.getDeviceTypeName()))
                .price(dto.getPrice())
                .build();
    }

    @Override
    public ServiceDTO newDTOInstance() {
        return new ServiceDTO();
    }

    @Override
    public ServiceEntity newEntityInstance() {
        return new ServiceEntity();
    }

}
