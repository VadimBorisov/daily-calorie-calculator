package ru.vadim.home.dailycaloriecalculator.core.validations;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.vadim.home.dailycaloriecalculator.dto.UserRequest;
import ru.vadim.home.dailycaloriecalculator.dto.ValidationError;

import java.util.Optional;

@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class UserNameValidation implements RequestValidation<UserRequest> {
    @Override
    public Optional<ValidationError> validate(UserRequest request) {
        return (request.getName() == null || request.getName().isEmpty()) 
                ? Optional.of(new ValidationError("Field name cannot be empty!")) 
                : Optional.empty();
    }
}
