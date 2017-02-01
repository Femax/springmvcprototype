package com.advantum.logistumrest.dao;

import com.advantum.logistumrest.model.Ticket;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * Created by fedosov on 1/17/17.
 */
@PreAuthorize("hasRole('ROLE_MANAGER')")
public interface TicketRepository extends PagingAndSortingRepository<Ticket, Long> {
    @Override
    @PreAuthorize("#ticket?.customer == null or #employee?.manager?.name == authentication?.name")
    Ticket save(Ticket ticket);
    @Override
    @PreAuthorize("@ticketRepository.findOne(#id)?.manager?.name == authentication?.name")
    void delete(@Param("id") Long id);
    @Override
    @PreAuthorize("#ticket?.manager?.name == authentication?.name")
    void delete(@Param("ticket") Ticket ticket);

}
