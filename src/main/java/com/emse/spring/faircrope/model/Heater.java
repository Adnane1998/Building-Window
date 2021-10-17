package com.emse.spring.faircrope.model;

import javax.persistence.*;

@Entity
public class Heater {
    public Heater() {
    }

    public Heater(Long id, String name, Long power, Room room, HeaterStatus heaterStatus) {
        this.id = id;
        this.name = name;
        this.power = power;
        this.room = room;
        this.heaterStatus = heaterStatus;
    }

    @Id
@GeneratedValue
private Long id;

@Column(nullable=false, length=255)
private String name;

private Long power;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getPower() {
        return power;
    }

    public Room getRoom() {
        return room;
    }

    public HeaterStatus getHeaterStatus() {
        return heaterStatus;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setHeaterStatus(HeaterStatus heaterStatus) {
        this.heaterStatus = heaterStatus;
    }


@ManyToOne(optional = false)
    private Room room;
@Enumerated(EnumType.STRING)
@Column(nullable=false)
private HeaterStatus heaterStatus;
}
