package ru.vadim.home.dailycaloriecalculator.core.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "dish")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "calories_per_serving", nullable = false)
    private int caloriesPerServing;

    @Column(name = "proteins_fats_carbohydrates", nullable = false)
    private String proteinsFatsCarbohydrates;

    @ManyToMany(mappedBy = "dishes")
    private List<User> users;
}
