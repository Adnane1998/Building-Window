package com.emse.spring.faircrope.api;

import com.emse.spring.faircrope.Repository.HeaterDao;
import com.emse.spring.faircrope.Repository.RoomDao;
import com.emse.spring.faircrope.model.*;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController // (1)
@RequestMapping("/api/rooms") // (2)
@Transactional // (3)
public class RoomController {


    private final RoomDao roomDao;

    public RoomController(RoomDao roomDao) {
        this.roomDao = roomDao; // (4)
    }

    @GetMapping // (5)
    public List<RoomDto> findAll() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());  // (6)
    }

    @GetMapping(path = "/{id}")
    public RoomDto findById(@PathVariable Long id) {
        return roomDao.findById(id).map(RoomDto::new).orElse(null); // (7)
    }



    @PostMapping // (8)
    public RoomDto create(@RequestBody RoomDto dto) {


        Room room = null;
        // On creation id is not defined
        if (dto.getId() == null) {
            room = roomDao.save(new Room(dto.getFloor(),dto.getName()));
        }
        else {
            room = roomDao.getById(dto.getId());  // (9)

        }
        return new RoomDto(room);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        roomDao.deleteById(id);
    }

    @PutMapping(path = "/{room_id}/switchWindow")
    public RoomDto switchStatusWindows(@PathVariable Long room_id) {
        Room room = roomDao.findById(room_id).orElseThrow(IllegalArgumentException::new);
        for(Window w : room.getWindows()) {
            w.setWindowStatus(w.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED: WindowStatus.OPEN);
        }

        return new RoomDto(room);
    }
    @PutMapping(path = "/{room_id}/switchHeaters")
    public RoomDto switchStatusHeaters(@PathVariable Long room_id) {
        Room room = roomDao.findById(room_id).orElseThrow(IllegalArgumentException::new);
        for(Heater h : room.getHeaters()) {
            h.setHeaterStatus(h.getHeaterStatus() == HeaterStatus.ON ? HeaterStatus.OFF: HeaterStatus.ON);
        }

        return new RoomDto(room);
    }
}
class RoomDto {
    private Long id;
    private String name;
    private Double CT;
    private Double TT;

    private Integer floor;



    public void setFloor(Integer floor) {
        this.floor = floor;
    }


    public Integer getFloor() {
        return floor;
    }

    private String roomName;
    private Long roomId;

    public RoomDto() {
    }

    public Double getCT() {
        return CT;
    }

    public Double getTT() {
        return TT;
    }

    public RoomDto(Room room) {
        this.id = room.getID();
        this.name =room.getName();
        this.CT=room.getCT();
        this.TT=room.getTT();
        this.floor = room.getFloor();

    }

    public Long getId() {
        return id;
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



}