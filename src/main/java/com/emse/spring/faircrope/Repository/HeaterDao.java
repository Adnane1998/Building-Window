package com.emse.spring.faircrope.Repository;

import com.emse.spring.faircrope.model.Heater;
import com.emse.spring.faircrope.model.Room;
import com.emse.spring.faircrope.model.Window;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface HeaterDao extends JpaRepository<Heater,Long> {
    @Transactional
    @Modifying
    @Query("Delete from Heater h where h.room.ID=:id")
    void DeleteByRoom(@Param("id") Long id);
}
