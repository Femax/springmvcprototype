package com.advantum.logistumrest.dao;



import com.advantum.logistumrest.model.RouteStartAddress;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by fedosov on 1/17/17.
 */
@RepositoryRestResource(exported = false)
public interface RouteStartAddressRepository extends PagingAndSortingRepository<RouteStartAddress, Long> {
    RouteStartAddress save(RouteStartAddress address);
}
