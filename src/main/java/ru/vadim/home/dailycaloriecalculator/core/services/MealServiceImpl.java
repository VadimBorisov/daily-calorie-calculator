package ru.vadim.home.dailycaloriecalculator.core.services;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vadim.home.dailycaloriecalculator.core.domain.Dish;
import ru.vadim.home.dailycaloriecalculator.core.domain.Meal;
import ru.vadim.home.dailycaloriecalculator.core.domain.User;
import ru.vadim.home.dailycaloriecalculator.core.repositories.DishRepository;
import ru.vadim.home.dailycaloriecalculator.core.repositories.MealRepository;
import ru.vadim.home.dailycaloriecalculator.core.repositories.UserRepository;
import ru.vadim.home.dailycaloriecalculator.core.validations.MealRequestValidator;
import ru.vadim.home.dailycaloriecalculator.dto.MealRequest;
import ru.vadim.home.dailycaloriecalculator.dto.MealResponse;
import ru.vadim.home.dailycaloriecalculator.dto.ValidationError;

import java.time.LocalDate;
import java.util.ArrayList;
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
        User user = userRepository.findById(mealRequest.getUserId()).get();

        Meal meal = new Meal();
        meal.setDishes(new ArrayList<>(mealRequest.getDishes().size()));

        for(String dishName : mealRequest.getDishes()) {
            Dish dish = dishRepository.findByName(dishName).get();
            meal.getDishes().add(dish);
            dish.getMeals().add(meal);
        }

        meal.setUser(user);
        user.getMeals().add(meal);

        mealRepository.save(meal);
        userRepository.save(user);
    }

    private MealResponse buildResponseWithoutErrors(MealRequest mealRequest) {
        MealResponse mealResponse = new MealResponse();

        mealResponse.setDishes(mealRequest.getDishes());
        mealResponse.setUserId(mealRequest.getUserId());
        mealResponse.setDate(LocalDate.now());

        return mealResponse;
    }

    private MealResponse buildResponseWithErrors(List<ValidationError> errors) {
        return new MealResponse(errors);
    }
}
