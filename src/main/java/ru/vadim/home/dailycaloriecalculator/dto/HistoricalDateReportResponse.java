package ru.vadim.home.dailycaloriecalculator.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.vadim.home.dailycaloriecalculator.core.domain.Meal;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HistoricalDateReportResponse extends CoreResponse {

    private String user;
    private List<Meal> meals;

    public HistoricalDateReportResponse(List<ValidationError> errors) {
        super(errors);
    }
}
