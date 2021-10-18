package com.emse.spring.faircrope;

import com.emse.spring.faircrope.Repository.HeaterDao;
import com.emse.spring.faircrope.Repository.RoomDao;
import com.emse.spring.faircrope.Repository.WindowDao;
import com.emse.spring.faircrope.model.Heater;
import com.emse.spring.faircrope.model.Room;
import com.emse.spring.faircrope.model.Window;
import com.emse.spring.faircrope.model.WindowStatus;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class HeaterDaoTest {

    @Autowired
    HeaterDao heaterDao;
    @Autowired
    RoomDao roomDao;


    @Test
    public void shouldDeleteWindowsRoom() {
        Room room = roomDao.getById(-10L);
        List<Long> roomIds = room.getWindows().stream().map(Window::getId).collect(Collectors.toList());
        Assertions.assertThat(roomIds.size()).isEqualTo(2);

        heaterDao.DeleteByRoom(-10L);
        List<Heater> result = heaterDao.findAllById(roomIds);
        Assertions.assertThat(result).isEmpty();

    }
}
