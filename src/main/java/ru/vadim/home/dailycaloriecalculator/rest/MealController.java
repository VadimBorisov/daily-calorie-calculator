package ru.vadim.home.dailycaloriecalculator.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vadim.home.dailycaloriecalculator.core.services.MealService;
import ru.vadim.home.dailycaloriecalculator.dto.MealRequest;
import ru.vadim.home.dailycaloriecalculator.dto.MealResponse;

@RestController
@RequestMapping("/calories-calculator/api/meal")
@RequiredArgsConstructor
public class MealController {
    private final MealService mealService;

    @PostMapping("/add")
    public MealResponse addMeal(@RequestBody MealRequest request) {
        return mealService.buildResponse(request);
    }
}
