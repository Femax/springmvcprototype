package com.advantum.logistumrest.config;

import com.advantum.logistumrest.model.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;

/**
 * Created by fedosov on 1/26/17.
 */
@Configuration
public class AppConfig {



    @Bean
    public ResourceProcessor<Resource<Ticket>> ticketProcessor() {

        return new ResourceProcessor<Resource<Ticket>>() {

            @Override
            public Resource<Ticket> process(Resource<Ticket> resource) {
                resource.getLinks();
                resource.removeLinks();
                return resource;
            }
        };
    }

    @Bean
    public ResourceProcessor<Resource<RouteItem>> routeItemProcessor() {

        return new ResourceProcessor<Resource<RouteItem>>() {

            @Override
            public Resource<RouteItem> process(Resource<RouteItem> resource) {
                resource.getLinks();
                resource.removeLinks();
                return resource;
            }
        };
    }

    @Bean
    public ResourceProcessor<Resource<Route>> routeProcessor() {

        return new ResourceProcessor<Resource<Route>>() {

            @Override
            public Resource<Route> process(Resource<Route> resource) {
                resource.getLinks();
                resource.removeLinks();
                return resource;
            }
        };
    }


    @Bean
    public ResourceProcessor<Resource<Address>> addressProcessor() {

        return new ResourceProcessor<Resource<Address>>() {

            @Override
            public Resource<Address> process(Resource<Address> resource) {
                resource.getLinks();
                resource.removeLinks();
                return resource;
            }
        };
    }


    @Bean
    public ResourceProcessor<Resource<Cargo>> cargoProcessor() {

        return new ResourceProcessor<Resource<Cargo>>() {

            @Override
            public Resource<Cargo> process(Resource<Cargo> resource) {
                resource.getLinks();
                resource.removeLinks();
                return resource;
            }
        };
    }


}
