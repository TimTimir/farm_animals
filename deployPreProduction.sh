#!/usr/bin/env bash

vagrant destroy -f
vagrant up
#vagrant provision
if [ $? -ne 0 ]; then
    exit
fi

ssh bosque.caimito.net docker exec sns_mongo_1 mongodump --out /backup
scp -r bosque.caimito.net:backup target/
vagrant ssh -c "mkdir -p backup"
vagrant scp target/backup :.

vagrant scp docker-compose-preprod.yml :animals.yml
  if [ $? -ne 0 ]; then
    exit
  fi

vagrant ssh -c "sudo docker pull snscaimito/animals"
  if [ $? -ne 0 ]; then
    exit
  fi
vagrant ssh -c "sudo docker-compose -f animals.yml up -d"

vagrant ssh -c "docker exec vagrant_mongo_1 mongorestore /backup"
