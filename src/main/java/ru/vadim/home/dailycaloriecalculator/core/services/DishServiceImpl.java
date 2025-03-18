package ru.vadim.home.dailycaloriecalculator.core.services;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vadim.home.dailycaloriecalculator.core.domain.Dish;
import ru.vadim.home.dailycaloriecalculator.core.repositories.DishRepository;
import ru.vadim.home.dailycaloriecalculator.core.validations.DishRequestValidator;
import ru.vadim.home.dailycaloriecalculator.dto.DishRequest;
import ru.vadim.home.dailycaloriecalculator.dto.DishResponse;
import ru.vadim.home.dailycaloriecalculator.dto.ValidationError;

import java.util.List;

@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class DishServiceImpl implements DishService {
    private final DishRepository dishRepository;
    private final DishRequestValidator validator;

    @Override
    public DishResponse buildResponse(DishRequest request) {
        List<ValidationError> errors = validator.validate(request);

        if(errors.isEmpty())
            createDish(request);

        return errors.isEmpty()
                ? buildResponseWithoutErrors(request)
                : buildResponseWithErrors(errors);
    }

    private void createDish(DishRequest request) {
        Dish dish = new Dish();
        dish.setName(request.getName());
        dish.setCaloriesPerServing(request.getCaloriesPerServing());
        dish.setProteinsFatsCarbohydrates(request.getProteinsFatsCarbohydrates());

        dishRepository.save(dish);
    }

    private DishResponse buildResponseWithoutErrors(DishRequest request) {
        DishResponse dishResponse = new DishResponse();
        dishResponse.setName(request.getName());
        dishResponse.setCaloriesPerServing(request.getCaloriesPerServing());
        dishResponse.setProteinsFatsCarbohydrates(request.getProteinsFatsCarbohydrates());

        return dishResponse;
    }

    private DishResponse buildResponseWithErrors(List<ValidationError> errors) {
        return new DishResponse(errors);
    }
}
