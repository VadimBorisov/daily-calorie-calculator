package ru.vadim.home.dailycaloriecalculator.core.services;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vadim.home.dailycaloriecalculator.core.domain.Meal;
import ru.vadim.home.dailycaloriecalculator.core.repositories.DishRepository;
import ru.vadim.home.dailycaloriecalculator.core.repositories.MealRepository;
import ru.vadim.home.dailycaloriecalculator.core.repositories.UserRepository;
import ru.vadim.home.dailycaloriecalculator.core.validations.MealRequestValidator;
import ru.vadim.home.dailycaloriecalculator.dto.MealRequest;
import ru.vadim.home.dailycaloriecalculator.dto.MealResponse;
import ru.vadim.home.dailycaloriecalculator.dto.ValidationError;

import java.util.List;

@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class MealServiceImpl implements MealService {
    private final MealRepository mealRepository;
    private final DishRepository dishRepository;
    private final UserRepository userRepository;
    private final MealRequestValidator validator;

    @Override
    public MealResponse buildResponse(MealRequest mealRequest) {
        List<ValidationError> errors = validator.validate(mealRequest);

        if (errors.isEmpty()) {
            createMeal(mealRequest);
        }

        return errors.isEmpty()
                ? buildResponseWithoutErrors(mealRequest)
                : buildResponseWithErrors(errors);
    }

    private void createMeal(MealRequest mealRequest) {
        Meal meal = new Meal();
        meal.setDish(dishRepository.findById(mealRequest.getDishId()).orElse(null));
        meal.setUser(userRepository.findById(mealRequest.getUserId()).orElse(null));

        mealRepository.save(meal);
    }

    private MealResponse buildResponseWithoutErrors(MealRequest mealRequest) {
        MealResponse mealResponse = new MealResponse();
        mealResponse.setDishId(mealRequest.getDishId());
        mealResponse.setUserId(mealRequest.getUserId());

        return mealResponse;
    }

    private MealResponse buildResponseWithErrors(List<ValidationError> errors) {
        return new MealResponse(errors);
    }
}
