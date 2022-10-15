FROM openjdk:17-jdk-slim
WORKDIR /app
COPY app/build/libs/app.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]