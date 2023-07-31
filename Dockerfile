FROM openjdk:11
COPY /build/libs/parsing.agent.ua-0.0.1-SNAPSHOT.jar /parsing.agent.ua.jar
EXPOSE 80
ENTRYPOINT java $JAVA_OPTS -jar parsing.agent.ua.jar