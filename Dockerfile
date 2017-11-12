FROM openjdk:8-jre-alpine

RUN mkdir /app

WORKDIR /app

ADD $TRAVIS_BUILD_DIR/ws-orders/target/ws-orders-1.0-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "/app/ws-orders-1.0-SNAPSHOT.jar"]
