FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY core-lending-renting.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]