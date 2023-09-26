# SHIFT_LAB_TEST_TASK

## Привет, мир!

Для тестирования этой задачи выполните следующие шаги:

1. Скачайте файлы.
2. Загрузите их в IntelliJ IDEA.
3. Запустите проект.

## База данных H2

Вы можете получить доступ к базе данных H2 по следующему адресу:

[local](http://localhost:8080/h2-console)

- Логин: testDB
- Пароль: 123123

Были созданы две отдельные таблицы для хранения данных разных типов.

## В проекте

### IntervalsCombiner

Это основной файл, который принимает массив интервалов, обрабатывает его и загружает в базу данных.

### MergingAlgorithm

Этот файл содержит алгоритм (само задание). Функция `mergeIntervals` обрабатывает интервалы и, если необходимо, объединяет их, а `getMinimumInterval` выбирает минимальный интервал.

## Использование POSTMAN

Для тестирования запросов использовался POSTMAN.

#### POST-запросы:

1. Для цифровых данных: [http://localhost:8080/api/v1/intervals/merge?kind=digits](http://localhost:8080/api/v1/intervals/merge?kind=digits)

2. Для буквенных данных: [http://localhost:8080/api/v1/intervals/merge?kind=letters](http://localhost:8080/api/v1/intervals/merge?kind=letters)

#### GET-запросы:

1. Для цифровых данных: [http://localhost:8080/api/v1/intervals/min?kind=digits](http://localhost:8080/api/v1/intervals/min?kind=digits)

2. Для буквенных данных: [http://localhost:8080/api/v1/intervals/min?kind=letters](http://localhost:8080/api/v1/intervals/min?kind=letters)

## Спасибо за внимание!
