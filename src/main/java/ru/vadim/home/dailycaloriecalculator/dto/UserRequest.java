package ru.vadim.home.dailycaloriecalculator.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String name;
    private int age;
    private String email;
    private int weight;
    private int height;
    private String goal;
}
