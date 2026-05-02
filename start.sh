#!/bin/bash
set -e

# Compilar y empaquetar la aplicación
./mvnw clean package -DskipTests

# Ejecutar la aplicación JAR generada
java -jar target/apirest-0.0.1-SNAPSHOT.jar
