package ru.vadim.home.dailycaloriecalculator.core.repositories;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.vadim.home.dailycaloriecalculator.core.domain.User;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void injectedComponentsAreNotNull() {
        assertNotNull(userRepository);
    }

    @Test
    void findByNameShouldReturnUser() {
        Optional<User> user = userRepository.findByName("Viktor");
        assertTrue(user.isPresent());
    }

    @Test
    void findByEmailShouldReturnUser() {
        Optional<User> user = userRepository.findByEmail("viktor1@testmail.ru");
        assertTrue(user.isPresent());
    }

    @Test
    void findByIdShouldReturnUser() {
        Optional<User> user = userRepository.findById(1L);
        assertTrue(user.isPresent());
    }
}