package ru.vadim.home.dailycaloriecalculator.core.validations;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.vadim.home.dailycaloriecalculator.dto.UserRequest;
import ru.vadim.home.dailycaloriecalculator.dto.ValidationError;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class UserRequestValidatorImpl implements UserRequestValidator {
    private final List<RequestValidation<UserRequest>> validations;

    @Override
    public List<ValidationError> validate(UserRequest userRequest) {
        return validations.stream()
                .map(validation -> validation.validate(userRequest))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
