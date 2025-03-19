package ru.vadim.home.dailycaloriecalculator.core.services;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vadim.home.dailycaloriecalculator.core.domain.Dish;
import ru.vadim.home.dailycaloriecalculator.core.domain.User;
import ru.vadim.home.dailycaloriecalculator.core.repositories.DishRepository;
import ru.vadim.home.dailycaloriecalculator.core.repositories.UserRepository;
import ru.vadim.home.dailycaloriecalculator.core.validations.MealRequestValidator;
import ru.vadim.home.dailycaloriecalculator.dto.MealRequest;
import ru.vadim.home.dailycaloriecalculator.dto.MealResponse;
import ru.vadim.home.dailycaloriecalculator.dto.ValidationError;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class MealServiceImpl implements MealService {

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
        List<Dish> dishes = new ArrayList<>();

        for(String dishName : mealRequest.getDishes()) {
            Dish dish = dishRepository.findByName(dishName).get();
            dish.getUsers().add(user);
            dishes.add(dish);
        }

        user.setDishes(dishes);

        userRepository.save(user);
    }

    private MealResponse buildResponseWithoutErrors(MealRequest mealRequest) {
        MealResponse mealResponse = new MealResponse();

        mealResponse.setDishes(mealRequest.getDishes());
        mealResponse.setUserId(mealRequest.getUserId());

        return mealResponse;
    }

    private MealResponse buildResponseWithErrors(List<ValidationError> errors) {
        return new MealResponse(errors);
    }
}
