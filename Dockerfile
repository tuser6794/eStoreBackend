# Use the base image as JDK 11
FROM openjdk:11

# Create an Argument with default path as target directory
ARG JAR_FILE=target/*.jar

# Copy the Jar file as app.jar
COPY ${JAR_FILE} app.jar

# Execute the jar file which will run the project on port 9090
ENTRYPOINT ["java","-jar","/app.jar"]