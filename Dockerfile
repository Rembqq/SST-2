#FROM openjdk:17-jdk-slim
#
#WORKDIR /app
#
## Копіюємо скомпільований jar-файл з локальної системи в контейнер
#COPY target/*.jar app.jar
#
## Вказуємо порт, на якому працюватиме програма
#EXPOSE 8080
#
## Команда для запуску Spring Boot програми
#ENTRYPOINT ["java", "-jar", "app.jar"]
# Этап сборки
FROM maven:3.8.8-eclipse-temurin-17 AS build
WORKDIR /app

# Копируем pom.xml и скачиваем зависимости
COPY pom.xml .
RUN mvn dependency:go-offline

# Копируем весь проект и собираем
COPY . .
RUN mvn clean package -DskipTests

# Этап запуска
FROM openjdk:17-jdk-slim
WORKDIR /app

# Копируем собранный .jar из предыдущего этапа
COPY --from=build /app/target/*.jar app.jar

# Указываем порт, на котором будет работать приложение
EXPOSE 8080

# Команда для запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]
