package com.emse.spring.faircrope.model;

import javax.persistence.*;

@Entity
@Table(name = "RWINDOW")
public class Window {
    public Window( Room room,String name, WindowStatus windowStatus) {
        this.name = name;
        this.windowStatus = windowStatus;
        this.room = room;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable=false)
    private String name;

    public Room getRoom() {
        return room;
    }

    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private WindowStatus windowStatus;

    public Window(Room room) {
        this.room = room;
    }

    @ManyToOne(optional = false)
    private Room room;
    public Window() {
    }

    public Window(String name, WindowStatus status) {
        this.windowStatus = status;
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WindowStatus getWindowStatus() {
        return windowStatus;
    }

    public void setWindowStatus(WindowStatus windowStatus) {
        this.windowStatus = windowStatus;
    }
}