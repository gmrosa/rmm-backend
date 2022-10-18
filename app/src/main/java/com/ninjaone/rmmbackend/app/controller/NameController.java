package com.ninjaone.rmmbackend.app.controller;

import com.ninjaone.rmmbackend.app.service.NameService;
import com.ninjaone.rmmbackend.model.dto.NameDTO;
import com.ninjaone.rmmbackend.model.entity.NameEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
public abstract class NameController<T extends NameEntity, D extends NameDTO> extends BaseController<T, D> {

    @GetMapping("query")
    public ResponseEntity<D> findByName(@RequestParam String name) {
        LOGGER.info(type + " findByName " + name);
        return new ResponseEntity<>(getService().findByName(name), HttpStatus.OK);
    }

    protected abstract NameService<T, D> getService();

}
