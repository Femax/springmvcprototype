package com.advantum.logistumrest.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
@Table(name = "route_item")
public class RouteItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @OneToOne(mappedBy = "routeItem")
    private RouteItemAddress address;
    //when create without annotation have erorr "syntax error at or near 'order'" reserved column name?!?!
    @Column(name = "order_t")
    private long order;
    //    @OneToOne(mappedBy ="routeItem")
//    private TimeInterval offloadTime;
    private String notes;
    @OneToOne(mappedBy = "routeItem")
    private Cargo cargo;
    @Column(name = "route_id", insertable = false, updatable = false)
    private long routeId;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "route_id")
    private Route route;

    public RouteItem() {
    }

    public RouteItem(int order, String notes, Cargo cargo, Route route) {
        this.address = address;
        this.order = order;
//        this.offloadTime = offloadTime;
        this.notes = notes;
        this.cargo = cargo;
        this.route = route;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RouteItemAddress getAddress() {
        return address;
    }

    public void setAddress(RouteItemAddress address) {
        this.address = address;
    }

    public long getOrder() {
        return order;
    }

    public void setOrder(long order) {
        this.order = order;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
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
