package ru.vadim.home.dailycaloriecalculator.core.validations;

import ru.vadim.home.dailycaloriecalculator.dto.MealRequest;
import ru.vadim.home.dailycaloriecalculator.dto.ValidationError;

import java.util.List;

public interface MealRequestValidator {
    List<ValidationError> validate(MealRequest mealRequest);
}
