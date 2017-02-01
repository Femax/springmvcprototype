package com.advantum.logistumrest.dao;

import com.advantum.logistumrest.model.Route;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by fedosov on 1/17/17.
 */
@RepositoryRestResource(exported = false)
public interface RouteRepository extends PagingAndSortingRepository<Route, Long> {

    Route save(Route route);
}
