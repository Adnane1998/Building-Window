package com.emse.spring.faircrope.Repository;

import com.emse.spring.faircrope.model.Window;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface WindowDao extends JpaRepository<Window, Long>,WindowDaoCustom {
    @Query("select c from Window c where c.name=:name")
    Window findByName(@Param("name") String name);



    @Transactional
    @Modifying
    @Query("DELETE FROM Window w WHERE w.room.ID=:id")
    void deleteByRoom(@Param("id") Long id);
}