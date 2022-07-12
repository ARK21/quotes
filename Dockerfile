FROM gradle:7.4.2-jdk8 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:8-jdk-alpine

COPY --from=build /home/gradle/src/build/libs/*.jar ./
ENV JAVA_OPTS="-Xms50M -Xmx300M"
CMD java $JAVA_OPTS -jar "/quotes.api-0.0.1-SNAPSHOT.jar"