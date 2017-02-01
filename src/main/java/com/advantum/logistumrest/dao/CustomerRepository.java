package com.advantum.logistumrest.dao;

import com.advantum.logistumrest.model.Customer;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by fedosov on 1/17/17.
 */
@RepositoryRestResource(exported = false)
public interface CustomerRepository extends Repository<Customer, Long> {

    Customer save(Customer customer);

    Customer findByLogin(String login);

}
