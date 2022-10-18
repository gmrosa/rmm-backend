package com.ninjaone.rmmbackend.app.repository;

import com.ninjaone.rmmbackend.model.entity.NameEntity;
import com.ninjaone.rmmbackend.model.exception.NameAlreadyExistsException;
import com.ninjaone.rmmbackend.model.exception.RecordNotFoundException;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface NameRepository<T extends NameEntity> extends BaseRepository<T> {

    Optional<T> findByName(String name);

    default T saveUnique(T entity) {
        if (findByName(entity.getName()).isPresent()) {
            throw new NameAlreadyExistsException(this.getClass(), entity.getName());
        }
        return save(entity);
    }

    default T findByNameOrFail(String name) {
        return findByName(name).orElseThrow(() -> new RecordNotFoundException(this.getClass(), name));
    }

}
