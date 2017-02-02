package com.advantum.logistumrest.config;

import com.advantum.logistumrest.dao.*;
import com.advantum.logistumrest.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final TicketRepository tickets;
    private final CustomerRepository customers;
    private final RouteRepository routes;
    private final RouteItemRepository routeItems;
    private final RouteStartAddressRepository routeStartaddresses;
	private final CargoRepository cargo;
	private final RouteItemAddressRepository routeItemAdresesses;
	private static final Logger logger = LoggerFactory.getLogger(DatabaseLoader.class);

	@Autowired
	public DatabaseLoader(TicketRepository ticketRepository,
						  CustomerRepository customerRepository,
						  RouteRepository routeRepository,
						  RouteItemRepository routeItem,
						  RouteStartAddressRepository routeStartAddressRepository,
						  CargoRepository cargoRepository, RouteItemAddressRepository routeItemAdressRepository ){

		this.tickets = ticketRepository;
		this.customers = customerRepository;
		this.routes = routeRepository;
		this.routeItems = routeItem;
		this.routeStartaddresses = routeStartAddressRepository;
		this.cargo = cargoRepository;
		this.routeItemAdresesses = routeItemAdressRepository;
	}

	@Override
	@Transactional
	public void run(String... strings) throws Exception {
		//Add customer
		Customer greg = this.customers.save(new Customer("Greg", "Greg", "Greg"
				,"greg","123456","+78005553535","+78005553535","ROLE_MANAGER"));
		Customer oliver = this.customers.save(new Customer("Oliver", "Oliver", "Oliver",
				"oliver","123456","+78003434535","+78003434535","ROLE_MANAGER"));
		//
		SecurityContextHolder.getContext().setAuthentication(
			new UsernamePasswordAuthenticationToken("greg", "doesn't matter",
				AuthorityUtils.createAuthorityList("ROLE_MANAGER")));


		Route route;
		Cargo cargo;

		Ticket ticket1 = this.tickets.save(new Ticket("11-11-17",TicketStatus.NEW,800,greg));
		route = this.routes.save(new Route(RouteStatus.NONE,ticket1));
		this.routeStartaddresses.save(new RouteStartAddress("Moscow",55.44,55.22,route));
		RouteItem routeItem =  this.routeItems.save(new RouteItem(0,"notes",route));
		this.cargo.save(new Cargo(200f,800f,4,routeItem, Cargo.Type.BOX));
		this.routeItemAdresesses.save(new RouteItemAddress("Moscow",55.44,55.22, routeItem));


		for(Ticket i:tickets.findAll()){
			logger.info(i.toString());
		}

		SecurityContextHolder.clearContext();
	}
}