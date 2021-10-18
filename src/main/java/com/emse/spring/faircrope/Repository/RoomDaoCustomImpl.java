package com.emse.spring.faircrope.Repository;

import com.emse.spring.faircrope.model.Window;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class RoomDaoCustomImpl implements RoomDaoCustom{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Window> findRoomByName(String name) {
        String jpql = "select c from Room c where c.name=:name";
        return em.createQuery(jpql, Window.class)
                .setParameter("name",name )
                .getResultList();

    }
}
