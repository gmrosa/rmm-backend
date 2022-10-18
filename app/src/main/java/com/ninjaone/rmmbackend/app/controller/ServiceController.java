package com.ninjaone.rmmbackend.app.controller;

import com.ninjaone.rmmbackend.app.service.BaseService;
import com.ninjaone.rmmbackend.app.service.ServiceService;
import com.ninjaone.rmmbackend.model.dto.ServiceDTO;
import com.ninjaone.rmmbackend.model.entity.ServiceEntity;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/service")
public class ServiceController extends BaseController<ServiceEntity, ServiceDTO> {

    private final ServiceService serviceService;

    @Override
    protected BaseService<ServiceEntity, ServiceDTO> getService() {
        return serviceService;
    }

}
