package com.ninjaone.rmmbackend.app.controller;

import com.ninjaone.rmmbackend.app.service.DeviceTypeService;
import com.ninjaone.rmmbackend.app.service.NameService;
import com.ninjaone.rmmbackend.model.dto.DeviceTypeDTO;
import com.ninjaone.rmmbackend.model.entity.DeviceTypeEntity;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/device-type")
public class DeviceTypeController extends NameController<DeviceTypeEntity, DeviceTypeDTO> {

    private final DeviceTypeService deviceTypeService;

    @Override
    protected NameService<DeviceTypeEntity, DeviceTypeDTO> getService() {
        return deviceTypeService;
    }

}
