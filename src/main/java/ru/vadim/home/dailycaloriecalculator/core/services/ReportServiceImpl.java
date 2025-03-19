package ru.vadim.home.dailycaloriecalculator.core.services;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vadim.home.dailycaloriecalculator.core.domain.Dish;
import ru.vadim.home.dailycaloriecalculator.core.domain.Meal;
import ru.vadim.home.dailycaloriecalculator.core.domain.User;
import ru.vadim.home.dailycaloriecalculator.core.repositories.MealRepository;
import ru.vadim.home.dailycaloriecalculator.core.repositories.UserRepository;
import ru.vadim.home.dailycaloriecalculator.dto.CheckCaloriesReportResponse;
import ru.vadim.home.dailycaloriecalculator.dto.DailyReportResponse;
import ru.vadim.home.dailycaloriecalculator.dto.ValidationError;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class ReportServiceImpl implements ReportService {

    private final UserRepository userRepository;
    private final MealRepository mealRepository;

    @Override
    public CheckCaloriesReportResponse buildCheckCaloriesReport(long userId) {
        User user = userRepository.findById(userId).orElse(null);

        return user == null
                ? buildCheckResponseWithError(new ValidationError(
                        "User with id = " + userId + " not found"))
                : buildCheckResponseWithoutError(user);
    }

    @Override
    public DailyReportResponse buildDailyUserReport(long userId, LocalDate date) {
        User user = userRepository.findById(userId).orElse(null);
        List<Meal> meals = mealRepository.findByDateAndUserId(date, userId);

        return user == null
                ? buildDailyUserReportWithError(
                        new ValidationError("User with id = " + userId + " not found"))
                : buildDailyUserReportWithoutError(user, meals);
    }

    private DailyReportResponse buildDailyUserReportWithError(ValidationError validationError) {
        return new DailyReportResponse(Collections.singletonList(validationError));
    }

    private DailyReportResponse buildDailyUserReportWithoutError(User user, List<Meal> meals) {
        DailyReportResponse response = new DailyReportResponse();
        response.setUser(user.getName());

        int dailyCaloriesSum = meals.stream()
                .flatMap(meal -> meal.getDishes().stream())
                .mapToInt(Dish::getCaloriesPerServing)
                .sum();

        response.setCaloriesSum(dailyCaloriesSum);
        response.setMeals(meals);

        return response;
    }

    private CheckCaloriesReportResponse buildCheckResponseWithError(ValidationError validationError) {
        return new CheckCaloriesReportResponse(Collections.singletonList(validationError));
    }

    private CheckCaloriesReportResponse buildCheckResponseWithoutError(User user) {
        int dailyCaloriesSum = user.getMeals().stream()
                .flatMap(meal -> meal.getDishes().stream())
                .mapToInt(Dish::getCaloriesPerServing)
                .sum();

        if (user.getDailyBmr() >= dailyCaloriesSum) {
            return new CheckCaloriesReportResponse("Пользователь уложился в свой лимит");
        }

        return new CheckCaloriesReportResponse("Пользователь превысил свой лимит");
    }
}
