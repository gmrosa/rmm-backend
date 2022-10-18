package com.ninjaone.rmmbackend.app.controller;

import com.ninjaone.rmmbackend.app.service.CustomerService;
import com.ninjaone.rmmbackend.model.dto.CustomerDTO;
import com.ninjaone.rmmbackend.model.dto.CustomerMontlyCostDTO;
import com.ninjaone.rmmbackend.model.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerController extends NameController<CustomerEntity, CustomerDTO> {

    private final CustomerService customerService;

    @GetMapping("monthly-cost/{id}")
    public ResponseEntity<CustomerMontlyCostDTO> getMonthlyCostById(@PathVariable String id) {
        LOGGER.info("CustomerEntity getMonthlyCostById " + id);
        return new ResponseEntity<>(CustomerMontlyCostDTO.builder().total(getService().getMonthlyCostById(id)).build(), HttpStatus.OK);
    }

    @Override
    protected CustomerService getService() {
        return customerService;
    }

}
