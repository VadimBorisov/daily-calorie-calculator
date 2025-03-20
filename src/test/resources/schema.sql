create table users(
                      id bigint primary key auto_increment,
                      name varchar(100) not null,
                      age int check (age > 0 and age < 101) not null,
                      email varchar(200) unique not null,
                      weight int check (weight > 0 and weight < 200) not null,
                      height int check (height > 0 and height < 250) not null,
                      goal varchar not null,
                      daily_bmr int
);

create unique index ix_user_email on users(email);
create unique index ix_user_name on users(name);

create table dish(
                     id bigint primary key auto_increment,
                     name varchar(100) not null,
                     calories_per_serving int not null,
                     proteins_fats_carbohydrates varchar(50) not null
);

create unique index ix_dish_name on dish(name);

create table meal(
                     id bigint primary key auto_increment,
                     date date,
                     user_id bigint references users(id)
);

create table meals_dishes(
                             meal_id bigint references meal(id),
                             dish_id bigint references dish(id)
);