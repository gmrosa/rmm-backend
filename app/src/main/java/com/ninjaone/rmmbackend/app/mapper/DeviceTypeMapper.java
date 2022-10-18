package com.ninjaone.rmmbackend.app.mapper;

import com.ninjaone.rmmbackend.model.dto.DeviceTypeDTO;
import com.ninjaone.rmmbackend.model.entity.DeviceTypeEntity;

public class DeviceTypeMapper extends NameMapper<DeviceTypeEntity, DeviceTypeDTO> {

    @Override
    public DeviceTypeDTO newDTOInstance() {
        return new DeviceTypeDTO();
    }

    @Override
    public DeviceTypeEntity newEntityInstance() {
        return new DeviceTypeEntity();
    }

}
