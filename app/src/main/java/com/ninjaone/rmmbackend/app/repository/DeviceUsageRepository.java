package com.ninjaone.rmmbackend.app.repository;

import com.ninjaone.rmmbackend.model.entity.CustomerEntity;
import com.ninjaone.rmmbackend.model.entity.DeviceEntity;
import com.ninjaone.rmmbackend.model.entity.DeviceUsageEntity;
import com.ninjaone.rmmbackend.model.exception.BadRequestException;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceUsageRepository extends BaseRepository<DeviceUsageEntity> {

    Optional<DeviceUsageEntity> findByCustomerAndDevice(CustomerEntity customer, DeviceEntity device);

    default DeviceUsageEntity saveUnique(DeviceUsageEntity entity) {
        if (findByCustomerAndDevice(entity.getCustomer(), entity.getDevice()).isPresent()) {
            throw new BadRequestException("Unique composite key (DeviceUsageEntity.customer/DeviceUsageEntity.device)");
        }
        return save(entity);
    }

}
