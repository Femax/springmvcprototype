package com.advantum.logistumrest.model;

import javax.persistence.*;
import java.util.UUID;

/**
 * time is collected in UTC
 */
@Entity
@Table(name = "time_interval")
public class TimeInterval {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private long start;
    private long end;

    @Column(name = "route_item_id", insertable = false, updatable = false)
    private long routeItemId;
    @OneToOne
    @JoinColumn(name = "route_item_id")
    private RouteItem routeItem;

    @Column(name = "route_id", insertable = false, updatable = false)
    private long routeId;
    @OneToOne
    @JoinColumn(name = "route_id")
    private Route route;

    public TimeInterval() {
    }

    public TimeInterval(long start, long end) {
        this.id = UUID.randomUUID().toString();
        this.start = start;
        this.end = end;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
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
