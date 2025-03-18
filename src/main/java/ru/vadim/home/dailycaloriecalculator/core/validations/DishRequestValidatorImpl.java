package ru.vadim.home.dailycaloriecalculator.core.validations;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.vadim.home.dailycaloriecalculator.dto.DishRequest;
import ru.vadim.home.dailycaloriecalculator.dto.ValidationError;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class DishRequestValidatorImpl implements DishRequestValidator {
    private final List<RequestValidation<DishRequest>> validations;

    @Override
    public List<ValidationError> validate(DishRequest dishRequest) {
        return validations.stream()
                .map(validation -> validation.validate(dishRequest))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
