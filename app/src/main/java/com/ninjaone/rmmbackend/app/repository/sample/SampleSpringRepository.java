package com.ninjaone.rmmbackend.app.repository.sample;

import com.ninjaone.rmmbackend.model.entity.Sample;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleSpringRepository extends CrudRepository<Sample, String>  {

}