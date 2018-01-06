FROM openjdk:8-jre

RUN apt-get -qq update
RUN apt-get -qq -y install supervisor
RUN apt-get -qq -y install procps
RUN apt-get -qq -y install net-tools

RUN mkdir /app
WORKDIR /app

ADD $TRAVIS_BUILD_DIR/ws-adverts/target/ws-adverts-1.0-SNAPSHOT.jar /app
ADD $TRAVIS_BUILD_DIR/ws-orders/target/ws-orders-1.0-SNAPSHOT.jar /app

EXPOSE 8081
EXPOSE 8082

ADD supervisor.conf /etc/supervisor/conf.d/tor.conf
CMD /usr/bin/supervisord -n 
