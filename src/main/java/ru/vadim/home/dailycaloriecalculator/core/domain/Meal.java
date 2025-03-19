//package ru.vadim.home.dailycaloriecalculator.core.domain;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.hibernate.annotations.CreationTimestamp;
//
//import java.time.LocalDate;
//
//@Table(name = "meal")
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class Meal {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @Column(name = "date")
//    @Temporal(TemporalType.DATE)
//    @CreationTimestamp
//    private LocalDate date;
//
//    @Column(name = "user_id")
//    private long userId;
//
//    @Column(name = "dish_id")
//    private long dishId;
//}
