FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app
COPY . .
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
RUN adduser -D runtime
USER runtime
EXPOSE 8080
ENTRYPOINT ["java", "-Xmx180m", "-Xms64m", "-XX:+UseSerialGC", "-XX:MaxMetaspaceSize=80m", "-jar", "app.jar"]
