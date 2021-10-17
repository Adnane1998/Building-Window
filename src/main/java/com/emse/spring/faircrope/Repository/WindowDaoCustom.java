package com.emse.spring.faircrope.Repository;

import com.emse.spring.faircrope.model.Window;

import java.util.List;

public interface WindowDaoCustom {
    List<Window> findRoomOpenWindows(Long id);
}