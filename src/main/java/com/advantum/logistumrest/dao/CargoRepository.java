package com.advantum.logistumrest.dao;

import com.advantum.logistumrest.model.Cargo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by fedosov on 1/17/17.
 */
@RepositoryRestResource(exported = false)
public interface CargoRepository extends PagingAndSortingRepository<Cargo, Long> {

    Cargo save(Cargo cargo);
}
