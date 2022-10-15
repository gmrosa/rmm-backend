package com.ninjaone.rmmbackend.app.repository.sample;

import com.ninjaone.rmmbackend.core.repository.SampleRepository;
import com.ninjaone.rmmbackend.model.entity.Sample;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class SampleRepositoryImpl implements SampleRepository {

    private SampleSpringRepository repository;

    @Override
    public Sample save(Sample sample) {
        return repository.save(sample);
    }

    @Override
    public Optional<Sample> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

}
