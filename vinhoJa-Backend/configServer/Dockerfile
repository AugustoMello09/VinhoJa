FROM amazoncorretto:17-alpine-jdk AS jdk-builder

WORKDIR /app

COPY ./configServer ./

RUN chmod +x mvnw

RUN ./mvnw package

FROM amazoncorretto:17-alpine

WORKDIR /app

COPY --from=jdk-builder /app/target/configServer-0.0.1-SNAPSHOT.jar .

ENV SPRING_PROFILES_ACTIVE=default

EXPOSE 8888

ENTRYPOINT ["java", "-jar", "configServer-0.0.1-SNAPSHOT.jar"]