# DataProducer

Service collects data from the simulator and sends it to Kafka pipeline

##Steps to install Kafka  (For windows)

1) Download source folder of kafka from location : https://kafka.apache.org/downloads

2) rename source folder name as "kafka"

3) Go on location : cd bin/windows

4) run Zookeper server:zookeeper-server-start.bat ../../config/zookeeper.properties

5) run Kafka server:kafka-server-start.bat ../../config/server.properties 

##Steps to install Redis cache (For windows)

1) Download redis from location : https://github.com/microsoftarchive/redis/releases/tag/win-2.8.2104

2) run redis using command : redis-server.exe
