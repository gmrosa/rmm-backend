package com.ninjaone.rmmbackend.app.service;

import com.ninjaone.rmmbackend.app.mapper.BaseMapper;
import com.ninjaone.rmmbackend.app.mapper.DeviceMapper;
import com.ninjaone.rmmbackend.app.repository.DeviceRepository;
import com.ninjaone.rmmbackend.app.repository.NameRepository;
import com.ninjaone.rmmbackend.model.dto.DeviceDTO;
import com.ninjaone.rmmbackend.model.entity.DeviceEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeviceService extends NameService<DeviceEntity, DeviceDTO> {

    private final DeviceRepository repository;
    private final DeviceMapper mapper;

    @Override
    protected NameRepository<DeviceEntity> getRepository() {
        return repository;
    }

    @Override
    protected BaseMapper<DeviceEntity, DeviceDTO> getMapper() {
        return mapper;
    }

}
