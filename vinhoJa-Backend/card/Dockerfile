FROM amazoncorretto:17-alpine-jdk AS jdk-builder

WORKDIR /app

COPY ./card ./

RUN chmod +x mvnw

RUN ./mvnw package 

FROM amazoncorretto:17-alpine

WORKDIR /app

COPY --from=jdk-builder /app/target/card-0.0.1-SNAPSHOT.jar .

ENV SPRING_PROFILES_ACTIVE=default

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "card-0.0.1-SNAPSHOT.jar"]