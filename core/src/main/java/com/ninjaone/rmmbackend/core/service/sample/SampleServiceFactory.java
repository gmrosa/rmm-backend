package com.ninjaone.rmmbackend.core.service.sample;

import com.ninjaone.rmmbackend.core.repository.SampleRepository;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SampleServiceFactory {

    public static SampleService newInstance(SampleRepository sampleRepository) {
        return new SampleServiceImpl(sampleRepository);
    }

}
