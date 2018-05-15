#!/bin/bash

ssh bosque.caimito.net mkdir -p backup
scp docker-compose.yml bosque.caimito.net:animals.yml
ssh bosque.caimito.net docker pull snscaimito/animals
ssh bosque.caimito.net docker-compose -f animals.yml up -d
