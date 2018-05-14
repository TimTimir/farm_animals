#!/usr/bin/env bash

# vagrant destroy -f
vagrant provision
if [ $? -ne 0 ]; then
    exit
fi

# acquire testdata from production

vagrant scp docker-compose-preprod.yml :animals.yml
  if [ $? -ne 0 ]; then
    exit
  fi

vagrant ssh -c "sudo docker pull snscaimito/animals"
  if [ $? -ne 0 ]; then
    exit
  fi
vagrant ssh -c "sudo docker-compose -f animals.yml up -d"
