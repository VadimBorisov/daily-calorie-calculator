package ru.vadim.home.dailycaloriecalculator.core.services;

import ru.vadim.home.dailycaloriecalculator.dto.MealRequest;
import ru.vadim.home.dailycaloriecalculator.dto.MealResponse;

public interface MealService {
    MealResponse buildResponse(MealRequest mealRequest);
}
