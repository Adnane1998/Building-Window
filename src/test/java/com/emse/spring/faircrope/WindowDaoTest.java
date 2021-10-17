package com.emse.spring.faircrope;

import com.emse.spring.faircrope.Repository.WindowDao;
import com.emse.spring.faircrope.model.Window;
import com.emse.spring.faircrope.model.WindowStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
 class WindowDaoTest {

    @Autowired
    WindowDao windowDao;

    @Test
    public void shouldFindAWindow() {
        Window window = windowDao.getById(-10L);
        Assertions.assertThat(window.getName()).isEqualTo("Window 1");
        Assertions.assertThat(window.getWindowStatus()).isEqualTo(WindowStatus.CLOSED);
    }
}
