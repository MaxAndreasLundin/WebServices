#!/usr/bin/env bash

docker run --rm -p 5432:5432 --name webservice -e POSTGRES_PASSWORD=password postgres:latest
