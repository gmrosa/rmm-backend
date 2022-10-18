package com.ninjaone.rmmbackend.app.service;

import com.ninjaone.rmmbackend.app.mapper.BaseMapper;
import com.ninjaone.rmmbackend.app.repository.BaseRepository;
import com.ninjaone.rmmbackend.model.dto.BaseDTO;
import com.ninjaone.rmmbackend.model.entity.BaseEntity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public abstract class BaseService<T extends BaseEntity, D extends BaseDTO> {

    public D get(String id) {
        return getMapper().toDTO(getRepository().findByIdOrFail(id));
    }

    public List<D> list() {
        return StreamSupport.stream(getRepository().findAll().spliterator(), false)
                .map(e -> getMapper().toDTO(e))
                .collect(Collectors.toList());
    }

    public D add(D dto) {
        return getMapper().toDTO(getRepository().save(getMapper().toEntity(dto)));
    }

    public D update(D dto) {
        T entity = getMapper().toEntity(dto);
        return getMapper().toDTO(getRepository().save(entity));
    }

    public void delete(String id) {
        getRepository().deleteByIdOrFail(id);
    }

    protected abstract BaseRepository<T> getRepository();

    protected abstract BaseMapper<T, D> getMapper();

}
