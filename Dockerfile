# ETAPA 1: Compilación usando Gradle 9.3 y JDK 25
FROM gradle:9.3-jdk25 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
# Construimos el .jar
RUN gradle bootJar --no-daemon -x test

# ETAPA 2: Imagen ligera para correr la aplicación
FROM eclipse-temurin:25-jdk-alpine
WORKDIR /app
# Copiamos el .jar generado en la etapa anterior
COPY --from=build /home/gradle/src/build/libs/*.jar app.jar

# Exponemos el puerto del servidor
EXPOSE 8080

# Comando para arrancar la app
ENTRYPOINT ["java", "-jar", "app.jar"]