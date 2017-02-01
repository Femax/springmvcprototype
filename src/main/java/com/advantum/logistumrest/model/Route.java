package com.advantum.logistumrest.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "route")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(mappedBy = "route")
    private RouteStartAddress startAddress;
    //    @OneToOne(mappedBy ="route")
//    private TimeInterval startInterval;
    private Long currentRouteItemId;
    @Enumerated(EnumType.STRING)
    private RouteStatus routeStatus = RouteStatus.NONE;
    @OneToMany(mappedBy = "route", fetch = FetchType.EAGER)
    private List<RouteItem> items;
    @Column(name = "ticket_id", insertable = false, updatable = false)
    private long ticketId;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    public Route() {
    }

    public Route(RouteStatus routeStatus, Ticket ticket) {
        this.routeStatus = routeStatus;
        this.ticket = ticket;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RouteStartAddress getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(RouteStartAddress startAddress) {
        this.startAddress = startAddress;
    }

    public Long getCurrentRouteItemId() {
        return currentRouteItemId;
    }

    public void setCurrentRouteItemId(Long currentRouteItemId) {
        this.currentRouteItemId = currentRouteItemId;
    }

    public RouteStatus getRouteStatus() {
        return routeStatus;
    }

    public void setRouteStatus(RouteStatus routeStatus) {
        this.routeStatus = routeStatus;
    }

    public List<RouteItem> getItems() {
        return items;
    }

    public void setItems(List<RouteItem> items) {
        this.items = items;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }


    //    public TimeInterval getStartInterval() {
//        return startInterval;
//    }
//
//    public void setStartInterval(TimeInterval startInterval) {
//        this.startInterval = startInterval;
//    }


}
