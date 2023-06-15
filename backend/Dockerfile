# all these instructions is layares 

# Use a Maven image to build the Java application
FROM maven:3.8.3-openjdk-17-slim AS build

# like cd in the directory inside the container
WORKDIR /app

# Copy the Maven project files to the container
COPY pom.xml .
COPY src ./src

# Build the Java application
RUN mvn package -DskipTests

# Use the same Java version for the runtime container
FROM openjdk:17.0.1-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the build stage to the runtime container
COPY --from=build /app/target/docker-0.0.1-SNAPSHOT.jar /app

# Copy the application.properties file to the container's config directory
COPY src/main/resources/application.properties ./config/
EXPOSE 8080
# Set the command to run the Java application
CMD ["java", "-jar", "docker-0.0.1-SNAPSHOT.jar"]
