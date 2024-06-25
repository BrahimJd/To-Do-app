FROM openjdk:24-ea-3-jdk

WORKDIR /app

COPY target/to-do-app-0.0.1-SNAPSHOT.jar /app/ToDoAppApplication.jar

EXPOSE 8080

CMD ["java", "-jar", "ToDoAppApplication.jar"]
