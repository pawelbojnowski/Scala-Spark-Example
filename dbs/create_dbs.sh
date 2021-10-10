#!/bin/sh

#remove existing docker images
ids=$(docker ps -aqf name=ScalaSparkExample.)
for id in $(echo $ids | tr "\n" " "); do
  docker container rm -f $id
done

#remove existing docker volumes
rm -rf ./volumesData

#create docker
docker-compose up -d

#setup import Cockroachdb
docker exec -i $(docker ps -aqf name=ScalaSparkExampleCockroachdb) ./cockroach sql --insecure --database=defaultdb < initCockroachdb.sql


echo "----------------------------------------------------\n"
echo "http://localhost:9042/  Cassandra (root/root)"
echo "http://localhost:3306/  MySql (root/root)"
echo "http://localhost:26257/ Cockroachdb  (root/root)"
echo "http://localhost:9090/  Cockroachdb dashboard"
echo "\n----------------------------------------------------"
