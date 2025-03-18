package ru.vadim.home.dailycaloriecalculator.core.validations;

import ru.vadim.home.dailycaloriecalculator.dto.DishRequest;
import ru.vadim.home.dailycaloriecalculator.dto.ValidationError;

import java.util.List;

public interface DishRequestValidator {
    List<ValidationError> validate(DishRequest dishRequest);
}
