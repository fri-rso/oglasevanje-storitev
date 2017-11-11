FROM openjdk:8-jre-alpine

RUN mkdir /app

WORKDIR /app

ADD /home/travis/build/fri-rso/oglasevanje-storitev/ws-orders/target/ws-orders-1.0-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "ws-adverts.jar"]
