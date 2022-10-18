package com.ninjaone.rmmbackend.app.service;

import com.ninjaone.rmmbackend.app.mapper.BaseMapper;
import com.ninjaone.rmmbackend.app.mapper.ServiceTypeMapper;
import com.ninjaone.rmmbackend.app.repository.NameRepository;
import com.ninjaone.rmmbackend.app.repository.ServiceTypeRepository;
import com.ninjaone.rmmbackend.model.dto.ServiceTypeDTO;
import com.ninjaone.rmmbackend.model.entity.ServiceTypeEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ServiceTypeService extends NameService<ServiceTypeEntity, ServiceTypeDTO> {

    private final ServiceTypeRepository serviceTypeRepository;
    private final ServiceTypeMapper mapper = new ServiceTypeMapper();

    @Override
    protected NameRepository<ServiceTypeEntity> getRepository() {
        return serviceTypeRepository;
    }

    @Override
    protected BaseMapper<ServiceTypeEntity, ServiceTypeDTO> getMapper() {
        return mapper;
    }

}
