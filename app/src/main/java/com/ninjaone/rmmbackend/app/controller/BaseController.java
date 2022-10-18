package com.ninjaone.rmmbackend.app.controller;

import com.ninjaone.rmmbackend.app.service.BaseService;
import com.ninjaone.rmmbackend.model.dto.BaseDTO;
import com.ninjaone.rmmbackend.model.entity.BaseEntity;
import com.ninjaone.rmmbackend.model.util.Generics;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
public abstract class BaseController<T extends BaseEntity, D extends BaseDTO> {

    protected String type = Generics.getFirstGenericType(this.getClass()).getSimpleName();

    @GetMapping("/{id}")
    public ResponseEntity<D> get(@PathVariable String id) {
        LOGGER.info(type + " get " + id);
        return new ResponseEntity<>(getService().get(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<D>> list() {
        LOGGER.info(type + " list");
        return new ResponseEntity<>(getService().list(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<D> add(@Valid @RequestBody D dto) {
        LOGGER.info(type + " add " + dto);
        return new ResponseEntity<>(getService().add(dto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<D> update(@PathVariable String id, @Valid @RequestBody D dto) {
        dto.setId(id);
        LOGGER.info(type + " update " + dto);
        return new ResponseEntity<>(getService().update(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        LOGGER.info(type + " delete " + id);
        getService().delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected abstract BaseService<T, D> getService();

}
