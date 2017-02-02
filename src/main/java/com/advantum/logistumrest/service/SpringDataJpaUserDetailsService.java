package com.advantum.logistumrest.service;

import com.advantum.logistumrest.dao.CustomerRepository;
import com.advantum.logistumrest.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by fedosov on 1/26/17.
 */
@Component
public class SpringDataJpaUserDetailsService implements UserDetailsService {

    private final CustomerRepository repository;

    @Autowired
    public SpringDataJpaUserDetailsService(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Customer customer = this.repository.findByLogin(login);
        return new User(customer.getLogin(), customer.getPassword(),
                AuthorityUtils.createAuthorityList(customer.getRole()));
    }



}