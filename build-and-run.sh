#!/bin/sh
export JDBC_DATABASE_URL="jdbc:postgresql://54.217.214.201:5432/dasvbg0eunt1vj?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory"
export JDBC_DATABASE_USERNAME="kulsnqjvxvjcyc"
export JDBC_DATABASE_PASSWORD="a17b7fc723bb2d3d20d15c67d2d900e87ac0ad38cd6962695151bbcde24a6dbb"
mvn clean test spring-boot:run
