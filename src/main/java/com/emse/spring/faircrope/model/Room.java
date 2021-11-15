package com.emse.spring.faircrope.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Room {
    public Room() {
    }

    public Room(long ID, Integer floor, String name, Double CT, Double TT, Set<Heater> heaters, Set<Window> windows) {
        this.ID = ID;
        this.floor = floor;
        this.name = name;
        this.CT = CT;
        this.TT = TT;
        this.heaters = heaters;
        this.windows = windows;
    }

    public long getID() {
        return ID;
    }

    public Integer getFloor() {
        return floor;
    }

    public String getName() {
        return name;
    }

    public Double getCT() {
        return CT;
    }

    public Double getTT() {
        return TT;
    }

    public Set<Heater> getHeaters() {
        return heaters;
    }

    public Set<Window> getWindows() {
        return windows;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCT(Double CT) {
        this.CT = CT;
    }

    public void setTT(Double TT) {
        this.TT = TT;
    }

    public void setHeaters(Set<Heater> heaters) {
        this.heaters = heaters;
    }

    public void setWindows(Set<Window> windows) {
        this.windows = windows;
    }

    @Id
    @GeneratedValue
    private long ID;

    public Room( Integer floor, String name) {

        this.floor = floor;
        this.name = name;
    }

    @Column(nullable = false)
    private Integer floor;
    @Column(nullable = false)
    private String name;
    private Double CT;
    private Double TT;
    @ManyToOne
    private Building building;
    @OneToMany(mappedBy = "room")
    private Set<Heater> heaters;
    @OneToMany(mappedBy = "room")
    private Set<Window> windows;
}
