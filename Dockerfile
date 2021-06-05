FROM openjdk:8-jre-alpine
WORKDIR /opt/app
RUN pwd
COPY /target/truelove.jar truelove.jar
ENTRYPOINT ["java", "-jar", "truelove.jar"]
EXPOSE 8080