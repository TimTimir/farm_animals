#!/bin/bash

display_help() {
  echo "Usage:"
  echo "<version>           release container for <version>"
}

release_container() {
	git checkout v$1
	
	mvn package
	if [ $? -ne 0 ]; then
    	exit
  	fi
	
	docker build -t snscaimito/animals:$1 --build-arg VERSION=$1 .
	docker tag  snscaimito/animals:$1 snscaimito/animals:latest
	
	git checkout master
}

if [ $# -eq 0 ]; then
  display_help
  exit 0
fi

release_container $1
