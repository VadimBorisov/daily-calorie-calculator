package ru.vadim.home.dailycaloriecalculator.core.services;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vadim.home.dailycaloriecalculator.core.domain.User;
import ru.vadim.home.dailycaloriecalculator.core.repositories.UserRepository;
import ru.vadim.home.dailycaloriecalculator.core.validations.UserRequestValidator;
import ru.vadim.home.dailycaloriecalculator.dto.UserRequest;
import ru.vadim.home.dailycaloriecalculator.dto.UserResponse;
import ru.vadim.home.dailycaloriecalculator.dto.ValidationError;

import java.util.List;

@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class UserServiceImpl implements UserService {
    private final UserRequestValidator requestValidator;
    private final UserRepository userRepository;

    @Override
    public UserResponse buildResponse(UserRequest userRequest) {
        List<ValidationError> errors = requestValidator.validate(userRequest);

        if(errors.isEmpty())
            createUser(userRequest);

        return errors.isEmpty()
                ? buildResponseWithoutErrors(userRequest)
                : buildResponseWithErrors(errors);
    }

    private void createUser(UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setAge(userRequest.getAge());
        user.setWeight(userRequest.getWeight());
        user.setHeight(userRequest.getHeight());
        user.setGoal(userRequest.getGoal());

        userRepository.save(user);
    }

    public UserResponse buildResponseWithoutErrors(UserRequest userRequest) {
        UserResponse userResponse = new UserResponse();

        userResponse.setAge(userRequest.getAge());
        userResponse.setGoal(userRequest.getGoal());
        userResponse.setEmail(userRequest.getEmail());
        userResponse.setWeight(userRequest.getWeight());
        userResponse.setHeight(userRequest.getHeight());
        userResponse.setName(userRequest.getName());
        userResponse.setDailyCalories(calculateBMR(userRequest));

        return userResponse;
    }

    private UserResponse buildResponseWithErrors(List<ValidationError> errors) {
        return new UserResponse(errors);
    }

    private int calculateBMR(UserRequest userRequest) {
        return (int) (88.36 + (userRequest.getWeight() * 13.4) + (4.8 * userRequest.getHeight())
                - (5.7 * userRequest.getAge()));
    }
}
