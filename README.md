```sh
To run locally:
1. docker run -e POSTGRES_PASSWORD=postgres --restart=always -p 5432:5432 -d postgres:9.4
2. mvn clean package # in cloned directory
3. run in command prompt and coonect sql database: psql -U postgres -h localhost # password is postgres
4. run sql command: create database adverts;
5. in both config.yaml change connection urls to localhost
6. download and start etcd
7. goto ws-adverts directory
8. run "java -jar target/ws-adverts-1.0-SNAPSHOT.jar"

--- 
For docker:
docker build -t ws-adverts .
docker run -d --link postgres-customers -p 8080:8080 ws-adverts
```

---

**kubernetes**
```sh
kubectl exec -ti postgres-5x41b bash
kubectl describe pods $POD_NAME
gcloud compute disks create --size 200GB postgresql-disk
kubectl delete deployment
```

--
```sh
kubectl create -f postgresql.yaml
kubectl create -f postgresql-service.yaml

kubectl run ws-adverts --image=frirso/ws-adverts
kubectl run ws-orders --image=frirso/ws-orders

kubectl expose deployment ws-orders --type=LoadBalancer --port 80 --target-port 8081
kubectl expose deployment ws-adverts --type=LoadBalancer --port 80 --target-port 8082
```

