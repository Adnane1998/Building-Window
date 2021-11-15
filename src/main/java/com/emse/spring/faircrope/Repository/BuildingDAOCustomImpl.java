package com.emse.spring.faircrope.Repository;


import com.emse.spring.faircrope.model.Heater;
import com.emse.spring.faircrope.model.Window;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BuildingDAOCustomImpl implements BuildingDaoCustom {
    @PersistenceContext
    private EntityManager em;

}
