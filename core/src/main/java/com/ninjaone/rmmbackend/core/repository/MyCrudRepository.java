package com.ninjaone.rmmbackend.core.repository;

import java.util.Optional;

interface MyCrudRepository<T, ID>  {

    T save(T entity);
    Optional<T> findById(ID id);
    void deleteById(ID id);

}
