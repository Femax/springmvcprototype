package com.advantum.logistumrest.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "Ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String createTime;
    @Enumerated(EnumType.STRING)
    private TicketStatus status;
    private float targetWeight;
    @Column(name = "customer_id", insertable = false, updatable = false)
    private long customerId;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToOne(mappedBy = "ticket")
    private Route route;

    public Ticket() {
    }

    public Ticket(String createTime, TicketStatus status, float targetWeight, Customer customer) {
        this.createTime = createTime;
        this.status = status;
        this.targetWeight = targetWeight;
        this.customer = customer;
        //    this.routeId = routeId;
        //   this.route = route;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public float getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(float targetWeight) {
        this.targetWeight = targetWeight;
    }

    public Route getRoute() {
        return route;
    }


    public void setRoute(Route route) {
        this.route = route;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


}
