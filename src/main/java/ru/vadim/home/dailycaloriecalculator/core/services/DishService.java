package ru.vadim.home.dailycaloriecalculator.core.services;

import ru.vadim.home.dailycaloriecalculator.dto.DishRequest;
import ru.vadim.home.dailycaloriecalculator.dto.DishResponse;

public interface DishService {
    DishResponse buildResponse(DishRequest request);
}
