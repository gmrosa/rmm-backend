package com.ninjaone.rmmbackend.app.repository;

import com.ninjaone.rmmbackend.model.converter.UUIDConverter;
import com.ninjaone.rmmbackend.model.entity.BaseEntity;
import com.ninjaone.rmmbackend.model.exception.RecordNotFoundException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends CrudRepository<T, UUID> {

    default T findByIdOrFail(String id) {
        UUID uuid = UUIDConverter.toUUID(id);
        return findById(uuid).orElseThrow(() -> new RecordNotFoundException(this.getClass(), uuid));
    }

    default void deleteByIdOrFail(String id) {
        UUID uuid = UUIDConverter.toUUID(id);
        if (!existsById(uuid)) throw new RecordNotFoundException(this.getClass(), uuid);
        deleteById(uuid);
    }

}
