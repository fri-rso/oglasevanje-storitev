docker run -e POSTGRES_PASSWORD=postgres --restart=always -p 5432:5432 -d postgres:9.4

mvn clean package

java -jar target/ws-adverts-1.0-SNAPSHOT.jar

docker run -d --link postgres-customers -p 8080:8080 ws-adverts
