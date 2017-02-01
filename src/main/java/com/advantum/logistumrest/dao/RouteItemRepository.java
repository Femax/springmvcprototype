package com.advantum.logistumrest.dao;

import com.advantum.logistumrest.model.RouteItem;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by fedosov on 1/17/17.
 */
@RepositoryRestResource(exported = false)
public interface RouteItemRepository extends PagingAndSortingRepository<RouteItem, Long> {
    RouteItem save(RouteItem routeItem);
}
