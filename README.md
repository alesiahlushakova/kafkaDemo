# Steps to reproduce:

#### Prerequisites:

- Maven
- Java 
- MySQL
- Kafka
- NiFi

## 1. Configure MySQL 
```mysql
create database ticket;
create database servicenow;
```

## 2. Start Kafka
```shell
zookeeper-server-start.bat ../../config/zookeeper.properties
kafka-server-start.bat ../../config/server.properties
```
## 3. Start Nifi
```shell
run-nifi.bat
```
- Import flow NiFi_Flows.json

![Alt text](NifiFlowsCapture.PNG?raw=true "Flow")

## 4. To test functionality use test.http file

