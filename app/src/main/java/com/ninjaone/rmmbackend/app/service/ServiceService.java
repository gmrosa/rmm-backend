package com.ninjaone.rmmbackend.app.service;

import com.ninjaone.rmmbackend.app.mapper.BaseMapper;
import com.ninjaone.rmmbackend.app.mapper.ServiceMapper;
import com.ninjaone.rmmbackend.app.repository.ServiceRepository;
import com.ninjaone.rmmbackend.model.dto.ServiceDTO;
import com.ninjaone.rmmbackend.model.entity.ServiceEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ServiceService extends BaseService<ServiceEntity, ServiceDTO> {

    private final ServiceRepository repository;
    private final ServiceMapper mapper;

    @Override
    public ServiceDTO add(ServiceDTO dto) {
        return getMapper().toDTO(getRepository().saveUnique(getMapper().toEntity(dto)));
    }

    @Override
    protected ServiceRepository getRepository() {
        return repository;
    }

    @Override
    protected BaseMapper<ServiceEntity, ServiceDTO> getMapper() {
        return mapper;
    }

}
