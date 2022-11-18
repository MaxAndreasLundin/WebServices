FROM openjdk:17-alpine AS BUILD_IMAGE

ENV APP_HOME=/root/dev/webservice/
RUN mkdir -p $APP_HOME/src/main/java
WORKDIR $APP_HOME

COPY ./build.gradle ./gradlew ./gradlew.bat $APP_HOME
COPY gradle $APP_HOME/gradle
COPY ./src $APP_HOME/src/

RUN ./gradlew clean build -x test

FROM openjdk:17-alpine
WORKDIR /root/
COPY --from=BUILD_IMAGE '/root/dev/webservice/build/libs/webservice-0.0.1-SNAPSHOT.jar' '/app/webservice.jar'
EXPOSE 8080
CMD ["java","-jar","/app/webservice.jar"]

