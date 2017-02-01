package com.advantum.logistumrest.model;


import javax.persistence.*;

@Entity
@Table(name = "truck")
public class Truck {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private String gosNumber;
    private int order;

    public Truck() {
    }

    public Truck(String id, String name, String gosNumber, int order) {
        this.id = id;
        this.name = name;
        this.gosNumber = gosNumber;
        this.order = order;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGosNumber() {
        return gosNumber;
    }

    public void setGosNumber(String gosNumber) {
        this.gosNumber = gosNumber;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return name + " " + gosNumber;
    }


}
