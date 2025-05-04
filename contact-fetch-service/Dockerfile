# Step 1: Use JDK base image
FROM openjdk:17-jdk-slim

# Step 2: Create a directory inside container
WORKDIR /app

# Step 3: Copy the JAR file
COPY target/contact-fetch-service-0.0.1-SNAPSHOT.jar app.jar

# Step 4: Expose the port your app runs on
EXPOSE 8082

# Step 5: Define the command to run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
