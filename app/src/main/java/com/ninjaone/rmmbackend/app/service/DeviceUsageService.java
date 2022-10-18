package com.ninjaone.rmmbackend.app.service;

import com.ninjaone.rmmbackend.app.mapper.BaseMapper;
import com.ninjaone.rmmbackend.app.mapper.DeviceUsageMapper;
import com.ninjaone.rmmbackend.app.repository.DeviceUsageRepository;
import com.ninjaone.rmmbackend.model.dto.DeviceUsageDTO;
import com.ninjaone.rmmbackend.model.entity.DeviceUsageEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeviceUsageService extends BaseService<DeviceUsageEntity, DeviceUsageDTO> {

    private final DeviceUsageRepository repository;
    private final DeviceUsageMapper mapper;

    @Override
    public DeviceUsageDTO add(DeviceUsageDTO dto) {
        return getMapper().toDTO(getRepository().saveUnique(getMapper().toEntity(dto)));
    }

    @Override
    protected DeviceUsageRepository getRepository() {
        return repository;
    }

    @Override
    protected BaseMapper<DeviceUsageEntity, DeviceUsageDTO> getMapper() {
        return mapper;
    }

}
