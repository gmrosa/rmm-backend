package com.ninjaone.rmmbackend.app.controller;

import com.ninjaone.rmmbackend.app.service.BaseService;
import com.ninjaone.rmmbackend.app.service.DeviceUsageService;
import com.ninjaone.rmmbackend.model.dto.DeviceUsageDTO;
import com.ninjaone.rmmbackend.model.entity.DeviceUsageEntity;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/device-usage")
public class DeviceUsageController extends BaseController<DeviceUsageEntity, DeviceUsageDTO> {

    private final DeviceUsageService deviceUsageService;

    @Override
    protected BaseService<DeviceUsageEntity, DeviceUsageDTO> getService() {
        return deviceUsageService;
    }

}
