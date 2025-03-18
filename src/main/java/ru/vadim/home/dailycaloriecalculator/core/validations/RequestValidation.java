package ru.vadim.home.dailycaloriecalculator.core.validations;

import ru.vadim.home.dailycaloriecalculator.dto.ValidationError;

import java.util.Optional;

public interface RequestValidation<T> {
    Optional<ValidationError> validate(T request);
}
