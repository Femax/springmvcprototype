package com.advantum.logistumrest.config;

import com.advantum.logistumrest.dao.CustomerRepository;
import com.advantum.logistumrest.model.*;
import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler({Ticket.class, Cargo.class, Route.class, RouteItem.class,Address.class})
public class SpringDataRestEventHandler {

	private final CustomerRepository customerRepository;

	@Autowired
    public SpringDataRestEventHandler(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@HandleBeforeCreate
	public void applyUserInformationUsingSecurityContext(Ticket ticket) {

		String login = SecurityContextHolder.getContext().getAuthentication().getName();
		Customer customer = this.customerRepository.findByLogin(login);
		if (customer == null) {
			Customer newManager = new Customer();
			newManager.setLogin(login);
			newManager.setRoles(new String[]{"ROLE_MANAGER"});
			customer = this.customerRepository.save(newManager);
		}
		ticket.setCustomer(customer);
	}


}