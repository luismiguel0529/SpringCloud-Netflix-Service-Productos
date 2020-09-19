FROM openjdk:14
VOLUME /tmp
ADD ./target/springboot-servicio-productos-0.0.1-SNAPSHOT.jar productos-server.jar
ENTRYPOINT ["java","-jar","/productos-server.jar"]