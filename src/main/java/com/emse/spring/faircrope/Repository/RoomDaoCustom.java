package com.emse.spring.faircrope.Repository;

import com.emse.spring.faircrope.model.Window;

import java.util.List;

public interface RoomDaoCustom {
    List<Window> findRoomByName(String name);
}
