# Setting Up Kafka docker on your machine

In order to try `Publish` and `Consume` messages from Apache Kafka, you need to have it up and running. I have demonstrated the example by spinning up a docker image of kafka. You can replicate that or install alternative way which ever feels the best. If you have chosen alternative way, please ignore below setup

## Prerequisites
* Install [Docker](https://www.docker.com/)
* Install [Docker Compose](https://docs.docker.com/compose/install/)

## Deploy ecosystem stack

Step 1: Clone the repository and checkout usecase

```shell
$ > git clone https://github.com/naddym/nifi-course-abm.git
$ > cd templates/integrating-with-kafka
```

Step 2: Deploy stack with docker-compose

```shell
$ > sudo docker-compose up -d
```

## Access Kafka from NiFi

Kafka cluster of 1 broker would be running on port `9093`, please use the same port when configuring the publish/consume kafka processors.

