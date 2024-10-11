# Use the official Ubuntu base image
FROM ubuntu:latest
LABEL authors="jaspe"

# Install Java (OpenJDK 11) on the Ubuntu base image
RUN apt-get update && apt-get install -y openjdk-11-jre

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file produced by the Maven build from Jenkins workspace to the container
# Ensure the JAR file is copied from the 'target' folder after the Maven build completes
COPY target/*.jar /app/app.jar

# Expose the port that your Java app will run on (e.g., 8080)
EXPOSE 8080

# The entrypoint to run the Java application inside the Docker container
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
