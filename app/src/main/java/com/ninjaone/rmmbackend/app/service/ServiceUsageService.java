package com.ninjaone.rmmbackend.app.service;

import com.ninjaone.rmmbackend.app.mapper.BaseMapper;
import com.ninjaone.rmmbackend.app.mapper.ServiceUsageMapper;
import com.ninjaone.rmmbackend.app.repository.ServiceUsageRepository;
import com.ninjaone.rmmbackend.model.dto.ServiceUsageDTO;
import com.ninjaone.rmmbackend.model.entity.ServiceUsageEntity;
import com.ninjaone.rmmbackend.model.exception.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ServiceUsageService extends BaseService<ServiceUsageEntity, ServiceUsageDTO> {

    private final ServiceUsageRepository repository;
    private final ServiceUsageMapper mapper;


    @Override
    public ServiceUsageDTO add(ServiceUsageDTO dto) {
        ServiceUsageEntity entity = getMapper().toEntity(dto);
        validate(entity);
        return getMapper().toDTO(getRepository().saveUnique(entity));
    }

    @Override
    public ServiceUsageDTO update(ServiceUsageDTO dto) {
        ServiceUsageEntity entity = getMapper().toEntity(dto);
        validate(entity);
        return getMapper().toDTO(getRepository().save(entity));
    }

    private void validate(ServiceUsageEntity entity) {
        if (entity.getService().getDeviceType() != null) {
            if (!entity.getService().getDeviceType().getId().equals(entity.getDeviceUsage().getDevice().getDeviceType().getId())) {
                throw new BadRequestException(String.format(
                        "Incompatible device type (ServiceUsageEntity.service.device.name='%s'/ServiceUsageEntity.deviceUsage.device.name='%s')",
                        entity.getService().getDeviceType().getName(),
                        entity.getDeviceUsage().getDevice().getDeviceType().getName()));
            }
        }
    }

    @Override
    protected ServiceUsageRepository getRepository() {
        return repository;
    }

    @Override
    protected BaseMapper<ServiceUsageEntity, ServiceUsageDTO> getMapper() {
        return mapper;
    }

}
