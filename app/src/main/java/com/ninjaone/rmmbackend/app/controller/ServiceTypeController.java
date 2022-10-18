package com.ninjaone.rmmbackend.app.controller;

import com.ninjaone.rmmbackend.app.service.NameService;
import com.ninjaone.rmmbackend.app.service.ServiceTypeService;
import com.ninjaone.rmmbackend.model.dto.ServiceTypeDTO;
import com.ninjaone.rmmbackend.model.entity.ServiceTypeEntity;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/service-type")
public class ServiceTypeController extends NameController<ServiceTypeEntity, ServiceTypeDTO> {

    private final ServiceTypeService serviceTypeService;

    @Override
    protected NameService<ServiceTypeEntity, ServiceTypeDTO> getService() {
        return serviceTypeService;
    }

}
