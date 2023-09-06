FROM openjdk:17-jdk-slim-buster
EXPOSE 8080
ADD target/myapp-0.0.1-SNAPSHOT.jar coffee_machine.jar
CMD ["java", "-jar", "/coffee_machine.jar"]