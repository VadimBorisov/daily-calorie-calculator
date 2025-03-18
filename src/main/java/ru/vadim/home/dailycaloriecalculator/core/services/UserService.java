package ru.vadim.home.dailycaloriecalculator.core.services;

import ru.vadim.home.dailycaloriecalculator.dto.UserRequest;
import ru.vadim.home.dailycaloriecalculator.dto.UserResponse;

public interface UserService {
    UserResponse buildResponse(UserRequest userRequest);
}
