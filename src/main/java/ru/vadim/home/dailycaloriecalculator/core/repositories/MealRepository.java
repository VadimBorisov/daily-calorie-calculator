package ru.vadim.home.dailycaloriecalculator.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.vadim.home.dailycaloriecalculator.core.domain.Meal;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
    Optional<Meal> findById(long id);

    @Query("select m from Meal m " +
            "left join m.user u " +
            "where u.name = :name")
    List<Meal> findByUserName(String name);

    List<Meal> findByDateAndUserId(LocalDate date, long userId);
}
