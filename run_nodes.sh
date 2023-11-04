#!/bin/bash
docker build -t node .
docker network create chord-network

for i in {1..10}
do
    docker run --net chord-network --name node$i -d node $i
done
