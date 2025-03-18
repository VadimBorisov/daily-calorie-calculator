package ru.vadim.home.dailycaloriecalculator.core.repositories;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.vadim.home.dailycaloriecalculator.core.domain.Meal;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class MealRepositoryTest {
    @Autowired
    private MealRepository mealRepository;

    @Test
    void injectedComponentsAreNotNull() {
        assertNotNull(mealRepository);
    }

    @Test
    void findById() {
        Optional<Meal> meal = mealRepository.findById(1L);
        assertTrue(meal.isPresent());
    }

    @Test
    void findByUserNameShouldReturnMeal() {
        List<Meal> meals = mealRepository.findByUserName("Viktor");
        assertFalse(meals.isEmpty());
        assertEquals("Viktor", meals.getFirst().getUser().getName());
    }

    @Test
    void shouldNotReturnMealWhenUserNameNotFound() {
        List<Meal> meals = mealRepository.findByUserName("Anna");
        assertTrue(meals.isEmpty());
    }
}