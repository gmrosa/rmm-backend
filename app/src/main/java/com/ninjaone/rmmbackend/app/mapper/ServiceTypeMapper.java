package com.ninjaone.rmmbackend.app.mapper;

import com.ninjaone.rmmbackend.model.dto.ServiceTypeDTO;
import com.ninjaone.rmmbackend.model.entity.ServiceTypeEntity;

public class ServiceTypeMapper extends NameMapper<ServiceTypeEntity, ServiceTypeDTO> {

    @Override
    public ServiceTypeDTO newDTOInstance() {
        return new ServiceTypeDTO();
    }

    @Override
    public ServiceTypeEntity newEntityInstance() {
        return new ServiceTypeEntity();
    }

}
