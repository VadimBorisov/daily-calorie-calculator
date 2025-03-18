package ru.vadim.home.dailycaloriecalculator.core.validations;

import ru.vadim.home.dailycaloriecalculator.dto.UserRequest;
import ru.vadim.home.dailycaloriecalculator.dto.ValidationError;

import java.util.Optional;

public class UserHeightValidation implements RequestValidation<UserRequest> {
    @Override
    public Optional<ValidationError> validate(UserRequest request) {
        return (request.getHeight() < 100 || request.getHeight() > 250)
                ? Optional.of(new ValidationError("Height must be between 100 cm and 250 cm!"))
                : Optional.empty();
    }
}
