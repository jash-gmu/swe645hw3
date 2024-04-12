FROM openjdk:17-jdk

# Copy the built JAR file into the container
COPY output/demo-0.0.1-SNAPSHOT.jar /demo.jar

# Expose port 8080 for the application
EXPOSE 8080

# Run the JAR file
CMD ["java", "-jar", "/demo.jar"]
