#!/bin/sh
while read service; do
    echo "Stopping services"
	if [ "$(docker ps -q -f name=$service)" ]; then
		docker stop $service
		docker rm $service
	fi
done < services.config