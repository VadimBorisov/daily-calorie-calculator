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
public class DishResponse extends CoreResponse {
    private String name;
    private int caloriesPerServing;
    private String proteinsFatsCarbohydrates;

    public DishResponse(List<ValidationError> errors) {
        super(errors);
    }
}
