# SHIFT_LAB_TEST_TASK
/////////////////////////////////////////////////////HELLO WORLD/////////////////////////////////////////////////////////////////////////////////////////////////////////



                                                    IntelliJIDEA


                                                  1) Скачать файлы
                                                  2) Закинуть их, к примеру, в IntelliJIDEA
                                                  3) Запустить)



/////////////////////////////////////////////////////БАЗА ДАННЫХ H2///////////////////////////////////////////////////////////////////////////////////////////////////////




[local](http://localhost:8080/h2-console)http://localhost:8080/h2-console

Логин - testDB


Пароль - 123123



Были созданы две отдельные таблицы для того чтобы хранить типы данных определенного вида




//////////////////////////////////////////////////////IN PROJECT//////////////////////////////////////////////////////////////////////////////////////////////////////////////////


IntervalsCombiner - основной файл, принимает массив с интервалами, обрабатывает его и закидывает в БД



MergingAlgorithm - файл с алгоритмом(с самим таском), mergeIntervals обрабатывает интервалы и если надо соединяет,getMinimumInterval выбирает минимальный интервал


////////////////////////////////////////////////////////POSTMAN/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                        Для запросов использовался POSTMAN


                                                 POST запросы:
                                                 
1)http://localhost:8080/api/v1/intervals/merge?kind=digits         -              для цифр
2)http://localhost:8080/api/v1/intervals/merge?kind=letters        -              для букв


                                                GET запросы:

1)http://localhost:8080/api/v1/intervals/min?kind=digits         -              для цифр
2)http://localhost:8080/api/v1/intervals/min?kind=letters        -              для букв
                                                


//////////////////////////////////////////////////////////////////СПАСИБО ЗА ВНИМАНИЕ!////////////////////////////////////////////////////////////////////////////////////////////////

