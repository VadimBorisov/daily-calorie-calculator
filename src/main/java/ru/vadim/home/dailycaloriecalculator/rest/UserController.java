package ru.vadim.home.dailycaloriecalculator.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vadim.home.dailycaloriecalculator.core.services.UserService;
import ru.vadim.home.dailycaloriecalculator.dto.UserRequest;
import ru.vadim.home.dailycaloriecalculator.dto.UserResponse;

@RestController
@RequestMapping("/calories-calculator/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/add")
    public UserResponse addUser(@RequestBody UserRequest userRequest) {

        return userService.buildResponse(userRequest);
    }
}
