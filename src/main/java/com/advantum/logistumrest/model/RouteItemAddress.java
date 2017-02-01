package com.advantum.logistumrest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by fedosov on 2/1/17.
 */
@Entity
@Table(name = "route_item_address")
public class RouteItemAddress extends Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "route_item_id", insertable = false, updatable = false)
    private long routeItemId;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "route_item_id")
    private RouteItem routeItem;

    public RouteItemAddress() {
    }

    public RouteItemAddress(String title, double lat, double lng, RouteItem routeItem) {
        super(title, lat, lng);
        this.routeItem = routeItem;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRouteItemId() {
        return routeItemId;
    }

    public void setRouteItemId(long routeItemId) {
        this.routeItemId = routeItemId;
    }

    public RouteItem getRouteItem() {
        return routeItem;
    }

    public void setRouteItem(RouteItem routeItem) {
        this.routeItem = routeItem;
    }
}
