# Use OpenJDK 17 base image
FROM openjdk:17-jdk-slim

# Add a volume for logs (optional)
VOLUME /tmp

# Set app jar name
ARG JAR_FILE=target/e-society-0.0.1-SNAPSHOT.jar

# Copy the jar file into the container
COPY ${JAR_FILE} app.jar

# Expose the port
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
