package com.ninjaone.rmmbackend.app.service;

import com.ninjaone.rmmbackend.app.mapper.BaseMapper;
import com.ninjaone.rmmbackend.app.mapper.CustomerMapper;
import com.ninjaone.rmmbackend.app.repository.CustomerRepository;
import com.ninjaone.rmmbackend.app.repository.NameRepository;
import com.ninjaone.rmmbackend.model.dto.CustomerDTO;
import com.ninjaone.rmmbackend.model.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService extends NameService<CustomerEntity, CustomerDTO> {

    private final CustomerRepository repository;
    private final CustomerMapper mapper = new CustomerMapper();

    public Float getMonthlyCostById(String id) {
        Float result = repository.getMonthlyCostById(id);
        return result == null ? 0 : result;
    }

    @Override
    protected NameRepository<CustomerEntity> getRepository() {
        return repository;
    }

    @Override
    protected BaseMapper<CustomerEntity, CustomerDTO> getMapper() {
        return mapper;
    }

}
