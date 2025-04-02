# Build stage
FROM eclipse-temurin:22.0.1_8-jdk AS builder

# Set the working directory
WORKDIR /app

# Copy the Maven wrapper and configuration files
COPY pom.xml ./
COPY .mvn/ .mvn/
COPY mvnw ./

# Download dependencies
RUN chmod +x ./mvnw && ./mvnw dependency:go-offline -B

# Build the project with Maven
RUN ./mvnw clean install -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:22.0.1_8-jre

# Set the working directory
WORKDIR /app

# Copy the built application from the builder stage
COPY --from=builder /app/app/target/app-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8080

# Set the entry point for the application
ENTRYPOINT ["java", "-jar", "app.jar"]
