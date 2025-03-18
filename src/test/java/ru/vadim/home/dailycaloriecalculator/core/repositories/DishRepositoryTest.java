package ru.vadim.home.dailycaloriecalculator.core.repositories;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.vadim.home.dailycaloriecalculator.core.domain.Dish;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class DishRepositoryTest {
    @Autowired
    private DishRepository dishRepository;

    @Test
    void injectedComponentIsNotNull() {
        assertNotNull(dishRepository);
    }

    @Test
    void findByNameShouldReturnDish() {
        Optional<Dish> dish = dishRepository.findByName("Pilaf");
        assertTrue(dish.isPresent());
        assertEquals("Pilaf", dish.get().getName());
    }

    @Test
    void findByIdShouldReturnDish() {
        Optional<Dish> dish = dishRepository.findById(2L);
        assertTrue(dish.isPresent());
        assertEquals("Pilaf", dish.get().getName());
    }

    @Test
    void shouldNotReturnDishWhenNameNotFount() {
        Optional<Dish> dish = dishRepository.findByName("Pil");
        assertFalse(dish.isPresent());
    }
}