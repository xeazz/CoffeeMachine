# Управление кофеваркой через браузер

Цель: *реализовать `REST`-приложение для работы кофемашины, управляемой через браузер. Использовать `SpringF ramework` или `Spring Boot`. Вести учет работы в `PostgesSQL`.
Интерфейс не нужен, запросы через на `SwaggeUI`.*

## Требования
- Spring Boot: **3.0.10**
- Java version: **17**
- База данных - **PostgreSQL**
- Сборщик пакетов - **Maven**
- Система управления миграциями БД: **Liquibase**
- Логирование: **@slf4j** (Путь: *logs/application.log*)
- Спецификация для описания: **SpringDoc OpenAPI 2.2.0**

## Запуск приложения
1. Необходимо собрать `jar`-архив со Spring Boot приложением. Для этого в терминале, в корне проекта необходимо выполнить команду:

   - Для gradle: ./gradlew clean build (если пишет Permission denied, тогда сначала выполните chmod +x ./gradlew).

    - Для maven: `./mvnw clean package` (если пишет Permission denied, тогда сначала выполните `chmod +x ./mvnw`).

2. Запускаем процесс создания образа Docker: `docker build -t coffee_machine:latest .`
3. Развертываем сервисы веб-приложения: `docker-compose up -d `

## Управление

[SpringDoc OpenAPI](https://localhost:8080/swagger-ui.html "Открой меня :)")


| Метод        | Описание                  |Команда|
|:------------:|---------------------------| -----:|
| POST         | Включить кофемашину       |`/start` |
| POST         | Выключить кофемашину      |`/stop` |
| GET          | Меню кофемашины           |`/menu` |
| GET          | Приготовить кофе          |`/make-coffee/{id}` |
| GET          | Список операций автомата  |`/list` |
| DELETE       | Удалить позицию           |`/delete/{id}` |
| POST         | Добавить позицию          |`/add `|
| PATCH        | Изменить стоимость товара |`/update` |


