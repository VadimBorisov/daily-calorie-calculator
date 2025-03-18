package ru.vadim.home.dailycaloriecalculator.core.validations;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.vadim.home.dailycaloriecalculator.dto.MealRequest;
import ru.vadim.home.dailycaloriecalculator.dto.ValidationError;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class MealRequestValidatorImpl implements MealRequestValidator {
    private final List<RequestValidation<MealRequest>> validations;

    @Override
    public List<ValidationError> validate(MealRequest mealRequest) {
        return validations.stream()
                .map(validation -> validation.validate(mealRequest))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
