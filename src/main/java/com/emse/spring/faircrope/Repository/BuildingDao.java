package com.emse.spring.faircrope.Repository;


import com.emse.spring.faircrope.model.Building;
import com.emse.spring.faircrope.model.Window;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuildingDao extends JpaRepository<Building, Long>, BuildingDaoCustom {



}
