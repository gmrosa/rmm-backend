package com.ninjaone.rmmbackend.app.mapper;

import com.ninjaone.rmmbackend.model.dto.NameDTO;
import com.ninjaone.rmmbackend.model.entity.NameEntity;

public abstract class NameMapper<T extends NameEntity, D extends NameDTO> extends BaseMapper<T, D> {

    @Override
    public D toDTO(T entity) {
        D dto = newDTOInstance();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    @Override
    public T toEntity(D dto) {
        T entity = newEntityInstance();
        entity.setId(dto.getUUID());
        entity.setName(dto.getName());
        return entity;
    }


}
