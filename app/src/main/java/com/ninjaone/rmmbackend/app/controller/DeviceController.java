package com.ninjaone.rmmbackend.app.controller;

import com.ninjaone.rmmbackend.app.service.DeviceService;
import com.ninjaone.rmmbackend.app.service.NameService;
import com.ninjaone.rmmbackend.model.dto.DeviceDTO;
import com.ninjaone.rmmbackend.model.entity.DeviceEntity;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/device")
public class DeviceController extends NameController<DeviceEntity, DeviceDTO> {

    private final DeviceService deviceService;

    @Override
    protected NameService<DeviceEntity, DeviceDTO> getService() {
        return deviceService;
    }

}
