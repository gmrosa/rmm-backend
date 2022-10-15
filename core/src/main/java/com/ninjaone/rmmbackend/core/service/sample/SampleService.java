package com.ninjaone.rmmbackend.core.service.sample;

import com.ninjaone.rmmbackend.model.entity.Sample;

import java.util.Optional;

public interface SampleService {

    Sample saveSampleEntity(Sample sample);
    Optional<Sample> getSampleEntity(String id);
    void deleteSampleEntity(String id);

}
