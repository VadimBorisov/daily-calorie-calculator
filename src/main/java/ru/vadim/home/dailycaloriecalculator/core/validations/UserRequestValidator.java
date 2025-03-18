package ru.vadim.home.dailycaloriecalculator.core.validations;

import ru.vadim.home.dailycaloriecalculator.dto.UserRequest;
import ru.vadim.home.dailycaloriecalculator.dto.ValidationError;

import java.util.List;

public interface UserRequestValidator {
    List<ValidationError> validate(UserRequest userRequest);
}
