# REST API сервис для отслеживания дневной нормы калорий пользователя и учета съеденных блюд.

## Перед запуском приложения необходимо создать базу данных Postgresql и изменить настройки в application.properties на свои параметры. После чего выполнить sql скрипты из папки database.

### Приложение имеет 6 основных эндпоинтов:
### /calories-calculator/api/user/add - добавление пользователя
### Формат запроса: 
{
    "name": "Name",
    "email": "name@mail.com",
    "age": 33,
    "height": 187,
    "weight": 100,
    "goal": "WEIGHT_LOSS"
}

### /calories-calculator/api/dish/add - добавление блюда
### Формат запроса:
{
"name": "Рагу",
"caloriesPerServing": 300,
"proteinsFatsCarbohydrates": "10/5/30"
}

### /calories-calculator/api/meal/add - добавление приёма пищи
### Формат запроса:
{
"userId": 1,
"dishes":["Vegetable stew", "Burger"]
}

### /calories-calculator/api/report/{userId}/dailySummary - получение списка приёмов пищи и суммарные калории пользователя по его ID за сегодняшний день
### /calories-calculator/api/report/{userId}/checkDailySummary - проверка уложился ли пользователь в свою суточную норму калорий
### /calories-calculator/api/report/{userId}/{date} - получение списка приёмов пищи и суммарные калории пользователя по его ID за выбранную дату