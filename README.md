# WebServices

Docker
PostgreSQL
REST
Account Manager

Run "docker compose up" in the terminal to start the application.

spring.datasource.url=jdbc:postgresql://${DB_HOST:localhost}:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=password

docker run --rm -p 5432:5432 --name stimjpostgres -e POSTGRES_PASSWORD=password postgres:latest
