FROM openjdk:17-jdk
COPY target/crud-0.0.1-SNAPSHOT.jar java-app.jar
ENTRYPOINT ["java","-jar","java-app.jar"]