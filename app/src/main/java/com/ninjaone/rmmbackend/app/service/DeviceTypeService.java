package com.ninjaone.rmmbackend.app.service;

import com.ninjaone.rmmbackend.app.mapper.BaseMapper;
import com.ninjaone.rmmbackend.app.mapper.DeviceTypeMapper;
import com.ninjaone.rmmbackend.app.repository.DeviceTypeRepository;
import com.ninjaone.rmmbackend.app.repository.NameRepository;
import com.ninjaone.rmmbackend.model.dto.DeviceTypeDTO;
import com.ninjaone.rmmbackend.model.entity.DeviceTypeEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeviceTypeService extends NameService<DeviceTypeEntity, DeviceTypeDTO> {

    private final DeviceTypeRepository repository;
    private final DeviceTypeMapper mapper = new DeviceTypeMapper();

    @Override
    protected NameRepository<DeviceTypeEntity> getRepository() {
        return repository;
    }

    @Override
    protected BaseMapper<DeviceTypeEntity, DeviceTypeDTO> getMapper() {
        return mapper;
    }

}
