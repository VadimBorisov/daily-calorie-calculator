package ru.vadim.home.dailycaloriecalculator.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vadim.home.dailycaloriecalculator.core.services.DishService;
import ru.vadim.home.dailycaloriecalculator.dto.DishRequest;
import ru.vadim.home.dailycaloriecalculator.dto.DishResponse;

@RestController
@RequestMapping("/calories-calculator/api/dish")
@RequiredArgsConstructor
public class DishController {
    private final DishService dishService;

    @PostMapping("/add")
    public DishResponse addDish(@RequestBody DishRequest request) {
        return dishService.buildResponse(request);
    }
}
