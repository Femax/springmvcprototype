package com.advantum.logistumrest.dao;

import com.advantum.logistumrest.model.RouteItemAddress;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by fedosov on 2/1/17.
 */
@RepositoryRestResource(exported = false)
public interface RouteItemAddressRepository extends PagingAndSortingRepository<RouteItemAddress, Long> {


    RouteItemAddress save(RouteItemAddress address);

}
