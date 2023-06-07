FROM amazoncorretto:17
WORKDIR /app
COPY target/* .
EXPOSE 8080
LABEL authors="Chyna Davis"
ENTRYPOINT ["java", "-jar", "cmdavis/java-final-project-0.0.1-SNAPSHOT.jar"]