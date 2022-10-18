package com.ninjaone.rmmbackend.app.repository;

import com.ninjaone.rmmbackend.model.entity.DeviceUsageEntity;
import com.ninjaone.rmmbackend.model.entity.ServiceEntity;
import com.ninjaone.rmmbackend.model.entity.ServiceUsageEntity;
import com.ninjaone.rmmbackend.model.exception.BadRequestException;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServiceUsageRepository extends BaseRepository<ServiceUsageEntity> {

    Optional<ServiceUsageEntity> findByDeviceUsageAndService(DeviceUsageEntity deviceUsage, ServiceEntity service);

    default ServiceUsageEntity saveUnique(ServiceUsageEntity entity) {
        if (findByDeviceUsageAndService(entity.getDeviceUsage(), entity.getService()).isPresent()) {
            throw new BadRequestException("Unique composite key (ServiceUsageEntity.deviceUsage/ServiceUsageEntity.service)");
        }
        return save(entity);
    }

}