#!/bin/bash -xe
mvn clean install
docker-compose build
docker-compose up