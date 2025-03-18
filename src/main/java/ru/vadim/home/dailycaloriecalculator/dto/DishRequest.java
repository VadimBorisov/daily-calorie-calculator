package ru.vadim.home.dailycaloriecalculator.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DishRequest {
    private String name;
    private int caloriesPerServing;
    private String proteinsFatsCarbohydrates;
}
