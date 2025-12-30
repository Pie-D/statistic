# ===== STAGE 1: BUILD =====
FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom trước để tận dụng cache
COPY pom.xml .
RUN mvn -B dependency:go-offline

# Copy source code
COPY src ./src

# Build jar
RUN mvn clean package -DskipTests


# ===== STAGE 2: RUN =====
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copy jar từ stage build
COPY --from=build /app/target/*.jar app.jar

# Expose port (Spring Boot default)
EXPOSE 8080

# Run application
ENTRYPOINT ["java", "-jar", "app.jar"]
