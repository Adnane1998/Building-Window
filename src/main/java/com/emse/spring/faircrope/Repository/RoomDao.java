package com.emse.spring.faircrope.Repository;

import com.emse.spring.faircrope.model.Room;
import com.emse.spring.faircrope.model.Window;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomDao extends JpaRepository<Room, Long>{

    @Query("select c from Room c where c.ID=:id")

     Room getById(@Param("id") Long id);
}
