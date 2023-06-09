#!/bin/bash
cd "$(dirname "$0")/.." || exit
mvn clean install -DskipTests
docker-compose up