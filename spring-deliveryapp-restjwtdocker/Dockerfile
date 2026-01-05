FROM  eclipse-temurin:21
EXPOSE 8080
COPY target/spring-deliveryapp-restjwtdocker-0.0.1-SNAPSHOT.jar deliveryapp-jwt.jar
ENTRYPOINT [ "java", "-jar","deliveryapp-jwt.jar" ]