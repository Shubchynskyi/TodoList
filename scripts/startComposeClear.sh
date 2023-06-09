#!/bin/bash
cd "$(dirname "$0")/.." || exit
mvn clean install
docker-compose up