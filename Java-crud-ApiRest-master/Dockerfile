FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app
COPY Java-crud-ApiRest-master/ .
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
RUN useradd -m runtime
USER runtime
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
