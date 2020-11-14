#!/bin/bash

bash liquibase.sh | awk '{print "liquiBase script: " $0}' &

bash docker-entrypoint.sh postgres
