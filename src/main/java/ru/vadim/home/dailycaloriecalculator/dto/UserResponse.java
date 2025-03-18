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
public class UserResponse extends CoreResponse {
    private String name;
    private int age;
    private String email;
    private int weight;
    private int height;
    private String goal;
    private int dailyCalories;

    public UserResponse(List<ValidationError> errors) {
        super(errors);
    }
}
