package com.emse.spring.faircrope.Repository;

import com.emse.spring.faircrope.model.Window;
import com.emse.spring.faircrope.model.WindowStatus;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class WindowDaoCustomImpl implements WindowDaoCustom{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Window> findRoomOpenWindows(Long id) {
        String jpql = "select w from Window w where w.room.ID = :ID and w.windowStatus= :status";
        return em.createQuery(jpql, Window.class)
                .setParameter("ID", id)
                .setParameter("status", WindowStatus.OPEN)
                .getResultList();

    }
}
