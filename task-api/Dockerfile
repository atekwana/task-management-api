# Multi stage docker file

# STAGE 1: building task management api
FROM maven:3.9.9-eclipse-temurin-21-jammy AS build
WORKDIR /app

# Copy dependency file (good practice for better caching)
COPY pom.xml .

# download dependencies
RUN mvn dependency:go-offline -B

# copy source code
COPY src ./src

# build application
RUN mvn clean package -DskipTests

# STAGE 2: run application
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app

# copy built JAR from build stage
COPY --from=build /app/target/task-api-0.0.1-SNAPSHOT.jar task-management-api.jar

# expose API port
EXPOSE 8080

# run application
ENTRYPOINT ["java", "-jar", "task-management-api.jar"]