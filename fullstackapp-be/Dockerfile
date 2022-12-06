FROM eclipse-temurin:19

RUN mkdir -p /app
WORKDIR /app


COPY target/todolist-be.jar /

ENTRYPOINT ["java", "-jar", "/todolist-be.jar"]
