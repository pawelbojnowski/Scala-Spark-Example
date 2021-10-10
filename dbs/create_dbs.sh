#!/bin/sh

#remove existing docker images
ids=$(docker ps -aqf name=ScalaSparkExample.)
for id in $(echo $ids | tr "\n" " "); do
  docker container rm -f $id
done

#remove existing docker volumes
rm -rf ./volumesData

#create docker
docker-compose up
