FROM amazoncorretto:17-alpine-jdk AS jdk-builder

WORKDIR /app

COPY ./user ./

RUN chmod +x mvnw

RUN ./mvnw package 

FROM amazoncorretto:17-alpine

WORKDIR /app

COPY --from=jdk-builder /app/target/user-0.0.1-SNAPSHOT.jar .

ENV SPRING_PROFILES_ACTIVE=default

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "user-0.0.1-SNAPSHOT.jar"]