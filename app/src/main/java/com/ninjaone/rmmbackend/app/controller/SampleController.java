package com.ninjaone.rmmbackend.app.controller;

import com.ninjaone.rmmbackend.app.repository.sample.SampleSpringRepository;
import com.ninjaone.rmmbackend.app.repository.sample.SampleRepositoryImpl;
import com.ninjaone.rmmbackend.core.service.sample.SampleService;
import com.ninjaone.rmmbackend.core.service.sample.SampleServiceFactory;
import com.ninjaone.rmmbackend.model.entity.Sample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Sample postSampleEntity(@RequestBody Sample sample) {
        return sampleService.saveSampleEntity(sample);
    }

    @GetMapping("/{id}")
    private Sample getSampleEntity(@PathVariable String id) {
        return sampleService.getSampleEntity(id)
                .orElseThrow();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteSampleEntity(@PathVariable String id) {
        sampleService.deleteSampleEntity(id);
    }

}
