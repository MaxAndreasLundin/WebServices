# WebServices

Docker
PostgreSQL
REST
Account Manager


spring.datasource.url=jdbc:postgresql://${DB_HOST:localhost}:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=password

To start the postgres server in a docker containter run the following code in your terminal.
docker run --rm -p 5432:5432 --name webservice -e POSTGRES_PASSWORD=password postgres:latest
