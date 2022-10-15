package com.ninjaone.rmmbackend.app.service;

import com.ninjaone.rmmbackend.app.repository.sample.SampleRepositoryImpl;
import com.ninjaone.rmmbackend.app.repository.sample.SampleSpringRepository;
import com.ninjaone.rmmbackend.core.service.sample.SampleService;
import com.ninjaone.rmmbackend.core.service.sample.SampleServiceFactory;
import com.ninjaone.rmmbackend.model.entity.Sample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SampleSpringService implements SampleService {

    private final SampleService sampleService;

    public SampleSpringService(@Autowired SampleSpringRepository repository) {
        this.sampleService = SampleServiceFactory.newInstance(new SampleRepositoryImpl(repository));
    }

    @Override
    public Sample saveSampleEntity(Sample sample) {
        return sampleService.saveSampleEntity(sample);
    }

    @Override
    public Optional<Sample> getSampleEntity(String id) {
        return sampleService.getSampleEntity(id);
    }

    @Override
    public void deleteSampleEntity(String id) {
        sampleService.deleteSampleEntity(id);
    }

}
