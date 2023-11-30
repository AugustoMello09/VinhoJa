FROM amazoncorretto:17-alpine-jdk AS jdk-builder

WORKDIR /app

COPY ./email ./

RUN chmod +x mvnw

RUN ./mvnw package 

FROM amazoncorretto:17-alpine

WORKDIR /app

COPY --from=jdk-builder /app/target/email-0.0.1-SNAPSHOT.jar .

ENV SPRING_PROFILES_ACTIVE=default

EXPOSE 8084

ENTRYPOINT ["java", "-jar", "email-0.0.1-SNAPSHOT.jar"]