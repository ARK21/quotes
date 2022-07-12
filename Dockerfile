FROM openjdk:8-jdk-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENV JAVA_OPTS="-Xms50M -Xmx300M"
CMD java $JAVA_OPTS -jar "/app.jar"