package com.ninjaone.rmmbackend.app.controller;

import com.ninjaone.rmmbackend.app.service.BaseService;
import com.ninjaone.rmmbackend.app.service.ServiceUsageService;
import com.ninjaone.rmmbackend.model.dto.ServiceUsageDTO;
import com.ninjaone.rmmbackend.model.entity.ServiceUsageEntity;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/service-usage")
public class ServiceUsageController extends BaseController<ServiceUsageEntity, ServiceUsageDTO> {

    private final ServiceUsageService serviceUsageService;

    @Override
    protected BaseService<ServiceUsageEntity, ServiceUsageDTO> getService() {
        return serviceUsageService;
    }

}
