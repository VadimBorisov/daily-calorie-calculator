package ru.vadim.home.dailycaloriecalculator.core.validations;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.vadim.home.dailycaloriecalculator.core.repositories.UserRepository;
import ru.vadim.home.dailycaloriecalculator.dto.MealRequest;
import ru.vadim.home.dailycaloriecalculator.dto.ValidationError;

import java.util.Optional;

@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class MealUserValidation implements RequestValidation<MealRequest> {
    private final UserRepository userRepository;

    @Override
    public Optional<ValidationError> validate(MealRequest request) {
        return userRepository.findById(request.getUserId()).isEmpty()
                ? Optional.of(new ValidationError("User with id = " + request.getUserId()
                    + " does not exist!"))
                :Optional.empty();
    }
}
