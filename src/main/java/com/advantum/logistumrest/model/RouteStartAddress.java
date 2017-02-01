package com.advantum.logistumrest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by fedosov on 2/1/17.
 */
@Entity
@Table(name = "route_start_address")
public class RouteStartAddress extends Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "route_id", insertable = false, updatable = false)
    private long routeId;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "route_id")
    private Route route;

    public RouteStartAddress() {

    }

    public RouteStartAddress(String title, double lat, double lng, Route route) {
        super(title, lat, lng);
        this.route = route;
    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public long getRouteId() {
        return routeId;
    }


    public void setRouteId(long routeId) {
        this.routeId = routeId;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
