package com.ninjaone.rmmbackend.app.repository;

import com.ninjaone.rmmbackend.model.entity.DeviceTypeEntity;
import com.ninjaone.rmmbackend.model.entity.ServiceEntity;
import com.ninjaone.rmmbackend.model.entity.ServiceTypeEntity;
import com.ninjaone.rmmbackend.model.exception.BadRequestException;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServiceRepository extends BaseRepository<ServiceEntity> {

    Optional<ServiceEntity> findByServiceTypeAndDeviceType(ServiceTypeEntity serviceType, DeviceTypeEntity deviceType);

    default ServiceEntity saveUnique(ServiceEntity entity) {
        if (findByServiceTypeAndDeviceType(entity.getServiceType(), entity.getDeviceType()).isPresent()) {
            throw new BadRequestException("Unique composite key (ServiceEntity.serviceType/ServiceEntity.deviceType)");
        }
        return save(entity);
    }

}