package ru.vadim.home.dailycaloriecalculator.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MealResponse extends CoreResponse {
    private long userId;
    private long dishId;

    public MealResponse(List<ValidationError> errors) {
        super(errors);
    }
}
