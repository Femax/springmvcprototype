package com.advantum.logistumrest.dao;

import com.advantum.logistumrest.model.Truck;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by fedosov on 1/17/17.
 */
@RepositoryRestResource(exported = false)
public interface TruckRepository extends Repository<Truck, Long> {
}
