insert into users(name, age, email, weight, height, goal, daily_bmr)
values ('Viktor', 34, 'viktor1@testmail.ru', 100, 186, 'WEIGHT_LOSS', 2500),
       ('Dmitriy', 20, 'dmitriy1@testmail.ru', 60, 190, 'WEIGHT_GAIN', 3000),
       ('Alina', 25, 'alina1@testmail.ru', 50, 175, 'WEIGHT_MAINTENANCE', 1500);

insert into dish(name, calories_per_serving, proteins_fats_carbohydrates)
values ('Hamburger', 500, '30/50/40'),
       ('Pilaf', 438, '20/20/20'),
       ('Vegetable stew', 100, '5/1/20');

insert into meal(date, user_id)
values ('2025-03-19', 1),
       ('2025-03-19', 1),
       ('2025-03-19', 2),
       ('2025-03-19', 2),
       ('2025-03-19', 3),
       ('2025-03-17', 1),
       ('2025-03-17', 1);

insert into meals_dishes(meal_id, dish_id)
values (1, 1),
       (1, 2),
       (2, 3),
       (3, 1),
       (4, 3),
       (5, 3);