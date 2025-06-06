FROM openjdk:17

WORKDIR /app/trusticket/

ARG JAR_PATH=../build/libs/
ARG RESOURCES_PATH=../build/resources/main/

COPY ${JAR_PATH}/*.jar /app/trusticket/trusticket-content.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "trusticket-content.jar"]