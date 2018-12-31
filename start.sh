#!/bin/sh
while read service; do
	echo "--- Starting service '$service'"
	path="services/$service"
   
    echo "Building docker image"   
	docker build -t $service $path
	
	if [ "$(docker ps -q -f name=$service)" ]; then
		echo "Stopping running service"
		docker stop $service
		docker rm $service
	fi
	
	echo "Starting new container"
	docker run -d -p 8080:8080 --name $service $service
done < services.config