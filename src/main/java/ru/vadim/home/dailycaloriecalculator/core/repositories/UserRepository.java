package ru.vadim.home.dailycaloriecalculator.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.vadim.home.dailycaloriecalculator.core.domain.User;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);
    Optional<User> findById(long id);

    @Query("select u from User u " +
            "left join u.meals m " +
            "where u.id = :userId and m.date = :date")
    Optional<User> findUserMealsByDate(LocalDate date, long userId);
}
