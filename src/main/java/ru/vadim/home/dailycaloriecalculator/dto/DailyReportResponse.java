package ru.vadim.home.dailycaloriecalculator.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.vadim.home.dailycaloriecalculator.core.domain.Meal;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DailyReportResponse extends CoreResponse {
    private String user;
    private int caloriesSum;
    private List<Meal> meals;

    public DailyReportResponse(List<ValidationError> errors) {
        super(errors);
    }


}
