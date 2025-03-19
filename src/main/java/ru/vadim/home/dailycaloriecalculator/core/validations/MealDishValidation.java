package ru.vadim.home.dailycaloriecalculator.core.validations;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.vadim.home.dailycaloriecalculator.core.domain.Dish;
import ru.vadim.home.dailycaloriecalculator.core.repositories.DishRepository;
import ru.vadim.home.dailycaloriecalculator.dto.MealRequest;
import ru.vadim.home.dailycaloriecalculator.dto.ValidationError;

import java.util.Optional;

@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class MealDishValidation implements RequestValidation<MealRequest> {
    private final DishRepository dishRepository;

    @Override
    public Optional<ValidationError> validate(MealRequest request) {
        for (String dishName : request.getDishes()) {
            Optional<Dish> dish = dishRepository.findByName(dishName);
            if (dish.isEmpty()) {
                return Optional.of(new ValidationError("Dish " + dishName + " not found"));
            }
        }

        return Optional.empty();
    }
}
