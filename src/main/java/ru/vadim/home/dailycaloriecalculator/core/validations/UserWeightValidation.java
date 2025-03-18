package ru.vadim.home.dailycaloriecalculator.core.validations;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.vadim.home.dailycaloriecalculator.dto.UserRequest;
import ru.vadim.home.dailycaloriecalculator.dto.ValidationError;

import java.util.Optional;

@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class UserWeightValidation implements RequestValidation<UserRequest> {
    @Override
    public Optional<ValidationError> validate(UserRequest request) {
        return (request.getWeight() < 20 || request.getWeight() > 300)
                ? Optional.of(new ValidationError("Weight must be between 20 kg and 300 kg"))
                : Optional.empty();
    }
}
