FROM openjdk:8-jre-alpine
WORKDIR /opt/app
RUN pwd
ENV JAVA_OPTS="-Dcom.sun.security.enableAIAcaIssuers=true"
COPY /target/truelove.jar truelove.jar
ENTRYPOINT ["java", "-jar", "-Dcom.sun.security.enableAIAcaIssuers=true","truelove.jar"]
EXPOSE 7000