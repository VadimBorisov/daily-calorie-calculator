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
Формат ответа: 
{
    "errors": null,
    "user": "Viktor",
    "caloriesSum": 100,
    "meals": [
        {
        "id": 8,
        "date": "2025-03-20",
        "dishes": [
            {
            "id": 3,
            "name": "Vegetable stew",
            "caloriesPerServing": 100,
            "proteinsFatsCarbohydrates": "5/1/20"
            }
        ]
    }
    ]
}

### /calories-calculator/api/report/{userId}/checkDailySummary - проверка уложился ли пользователь в свою суточную норму калорий
Формат ответа:
{
"errors": null,
"checkMessage": "Пользователь уложился в свой лимит"
}

### /calories-calculator/api/report/{userId}/{date} - получение списка приёмов пищи и суммарные калории пользователя по его ID за выбранную дату
Формат ответа:
{
"errors": null,
"user": "Viktor",
"caloriesSum": 1038,
"meals": [
{
"id": 1,
"date": "2025-03-19",
"dishes": [
{
"id": 1,
"name": "Hamburger",
"caloriesPerServing": 500,
"proteinsFatsCarbohydrates": "30/50/40"
},
{
"id": 2,
"name": "Pilaf",
"caloriesPerServing": 438,
"proteinsFatsCarbohydrates": "20/20/20"
}
]
},
{
"id": 2,
"date": "2025-03-19",
"dishes": [
{
"id": 3,
"name": "Vegetable stew",
"caloriesPerServing": 100,
"proteinsFatsCarbohydrates": "5/1/20"
}
]
}
]
}