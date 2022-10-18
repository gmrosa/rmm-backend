package com.ninjaone.rmmbackend.app.service;

import com.ninjaone.rmmbackend.app.repository.NameRepository;
import com.ninjaone.rmmbackend.model.dto.BaseDTO;
import com.ninjaone.rmmbackend.model.entity.NameEntity;

public abstract class NameService<T extends NameEntity, D extends BaseDTO> extends BaseService<T, D> {

    public D findByName(String name) {
        return getMapper().toDTO(getRepository().findByNameOrFail(name));
    }

    @Override
    public D add(D dto) {
        return getMapper().toDTO(getRepository().saveUnique(getMapper().toEntity(dto)));
    }

    protected abstract NameRepository<T> getRepository();

}
