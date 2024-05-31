FROM openjdk:17
COPY target/expense-tracker-0.0.1-SNAPSHOT.jar expense-tracker.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "expense-tracker.jar"]