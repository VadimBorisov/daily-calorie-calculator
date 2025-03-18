insert into "user"(name, age, email, weight, height, goal)
values ('Viktor', 34, 'viktor1@testmail.ru', 100, 186, 'WEIGHT_LOSS'),
       ('Dmitriy', 20, 'dmitriy1@testmail.ru', 60, 190, 'WEIGHT_GAIN'),
       ('Alina', 25, 'alina1@testmail.ru', 50, 175, 'WEIGHT_MAINTENANCE');

insert into dish(name, calories_per_serving, proteins_fats_carbohydrates)
values ('Hamburger', 500, '30/50/40'),
       ('Pilaf', 438, '20/20/20'),
       ('Vegedable stew', 100, '5/1/20');

insert into meal(user_id, dish_id)
values (1, 1),
       (1, 2),
       (2, 2),
       (3, 3);