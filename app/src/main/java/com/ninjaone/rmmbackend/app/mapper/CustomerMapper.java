package com.ninjaone.rmmbackend.app.mapper;

import com.ninjaone.rmmbackend.model.dto.CustomerDTO;
import com.ninjaone.rmmbackend.model.entity.CustomerEntity;

public class CustomerMapper extends NameMapper<CustomerEntity, CustomerDTO> {

    @Override
    public CustomerDTO newDTOInstance() {
        return new CustomerDTO();
    }

    @Override
    public CustomerEntity newEntityInstance() {
        return new CustomerEntity();
    }

}
