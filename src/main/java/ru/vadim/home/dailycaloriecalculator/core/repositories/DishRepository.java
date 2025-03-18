package ru.vadim.home.dailycaloriecalculator.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vadim.home.dailycaloriecalculator.core.domain.Dish;

import java.util.Optional;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
    Optional<Dish> findByName(String name);
    Optional<Dish> findById(long id);
}
