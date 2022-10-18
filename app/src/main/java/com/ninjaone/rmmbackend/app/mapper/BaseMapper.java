package com.ninjaone.rmmbackend.app.mapper;

import com.ninjaone.rmmbackend.model.dto.BaseDTO;
import com.ninjaone.rmmbackend.model.entity.BaseEntity;

public abstract class BaseMapper<T extends BaseEntity, D extends BaseDTO> {

    public abstract D toDTO(T entity);

    public abstract T toEntity(D dto);

    public abstract D newDTOInstance();

    public abstract T newEntityInstance();

}
