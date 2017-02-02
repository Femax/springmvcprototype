package com.advantum.logistumrest.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "cargo")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private float minWeight;
    private float maxWeight;
    private int count;
    private String temperatureAllowed;
    private String customerName;
    private Type type = Type.BOX;
    @Column(name = "route_item_id", insertable = false, updatable = false)
    private long routeItemId;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "route_item_id")
    private RouteItem routeItem;


    public Cargo() {
    }

    public Cargo(float minWeight, float maxWeight, int count, RouteItem routeItem, Type type) {
        this.routeItem = routeItem;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.count = count;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public float getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(float minWeight) {
        this.minWeight = minWeight;
    }

    public float getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(float maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getTemperatureAllowed() {
        return temperatureAllowed;
    }

    public void setTemperatureAllowed(String temperatureAllowed) {
        this.temperatureAllowed = temperatureAllowed;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    public enum Type {
        BOX,
    }
}
