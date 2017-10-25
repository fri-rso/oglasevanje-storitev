FROM openjdk:8-jre-alpine

RUN mkdir /app

WORKDIR /app

ADD ./ws-adverts.jar /app

EXPOSE 8080

CMD ["java", "-jar", "ws-adverts.jar"]
