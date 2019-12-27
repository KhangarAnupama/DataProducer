# DataProducer

Service collects data from the simulator and sends it to Kafka pipeline

## Steps to install Kafka  (For windows)

1) Download source folder of kafka from location : https://kafka.apache.org/downloads

2) rename source folder name as "kafka"

3) Go on location : cd bin/windows

4) run Zookeper server:zookeeper-server-start.bat ../../config/zookeeper.properties

5) run Kafka server:kafka-server-start.bat ../../config/server.properties 

## Steps to install Redis cache (For windows)

1) Download redis from location : https://github.com/microsoftarchive/redis/releases/tag/win-2.8.2104

2) run redis using command : redis-server.exe

## Command to create and run docker file

1) Create docker image : docker build -t <Application name>:latest .
eg: docker build -t data-producer:latest .

2) Run docker image :  sudo docker run -d  -p 8080:8080 <Application name>:latest
eg:  sudo docker run -d  -p 8080:8080 data-producer:latest

## Command to get container API's

1) To get docker container ID : sudo docker ps

2) To get container IP : sudo docker inspect <Container IP> | grep -i "IPaDDreSS"


