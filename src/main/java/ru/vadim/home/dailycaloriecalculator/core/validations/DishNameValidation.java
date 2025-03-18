package ru.vadim.home.dailycaloriecalculator.core.validations;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.vadim.home.dailycaloriecalculator.dto.DishRequest;
import ru.vadim.home.dailycaloriecalculator.dto.ValidationError;

import java.util.Optional;

@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class DishNameValidation implements RequestValidation<DishRequest> {
    @Override
    public Optional<ValidationError> validate(DishRequest request) {
        return (request.getName() == null || request.getName().isEmpty())
                ? Optional.of(new ValidationError("Dish name cannot be empty!"))
                : Optional.empty();
    }
}
