package org.example.wl2;

import org.example.wl2.model.Wish;
import org.example.wl2.repository.WishRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@SpringBootTest
@ActiveProfiles("test")
class WishListRepoTest {

    @Autowired
    private WishRepo repo;

    @Test
    void testfindAll() {
        List<Wish> wishes = repo.findAll();
        assertThat(wishes).isNotEmpty();
    }
}
