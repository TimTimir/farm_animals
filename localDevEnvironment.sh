#!/bin/bash

docker_down() {
	docker rm -f dev_animals_mongo
}

docker_up() {
	docker run -dit --name dev_animals_mongo -p 27017:27017 mongo
}

display_help() {
  echo "Usage:"
  echo "--help              displays help"
  echo "up                  run all containers"
  echo "down                put all containers down"
}

if [ $# -eq 0 ]; then
  display_help
  exit 0
fi

while :
do
    case "$1" in
      -h | --help)
          display_help
          exit 0
          ;;
      up)
          docker_up
          exit 0
          ;;
      down)
          docker_down
          exit 0
          ;;
      *)  # No more options
          break
          ;;
    esac
done
