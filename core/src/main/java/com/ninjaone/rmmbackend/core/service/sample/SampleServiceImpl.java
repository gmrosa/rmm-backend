package com.ninjaone.rmmbackend.core.service.sample;

import com.ninjaone.rmmbackend.core.repository.SampleRepository;
import com.ninjaone.rmmbackend.model.entity.Sample;

import java.util.Optional;

class SampleServiceImpl implements SampleService {
    private final SampleRepository sampleRepository;

    public SampleServiceImpl(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    @Override
    public Sample saveSampleEntity(Sample sample){
        return sampleRepository.save(sample);
    }

    @Override
    public Optional<Sample> getSampleEntity(String id){
        return sampleRepository.findById(id);
    }

    @Override
    public void deleteSampleEntity(String id) {
        sampleRepository.deleteById(id);
    }

}
