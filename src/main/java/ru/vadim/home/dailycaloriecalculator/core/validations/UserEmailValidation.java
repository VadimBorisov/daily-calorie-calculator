package ru.vadim.home.dailycaloriecalculator.core.validations;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.vadim.home.dailycaloriecalculator.core.repositories.UserRepository;
import ru.vadim.home.dailycaloriecalculator.dto.UserRequest;
import ru.vadim.home.dailycaloriecalculator.dto.ValidationError;

import java.util.Optional;

@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class UserEmailValidation implements RequestValidation<UserRequest> {
    private final UserRepository userRepository;

    @Override
    public Optional<ValidationError> validate(UserRequest request) {
        return userRepository.findByEmail(request.getEmail()).isPresent()
                ? Optional.of(new ValidationError("User email already exists!"))
                : Optional.empty();
    }
}
