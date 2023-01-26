# Setting Up PostgreSQL docker on your machine

In order to try out example of elasticsearch, you need to have it up and running. I have demonstrated the example by spinning up a docker image of elasticsearch and kibana. You can replicate that or install alternative way which ever feels the best. If you have chosen alternative way, please ignore below setup

## Prerequisites
* Install [Docker](https://www.docker.com/)
* Install [Docker Compose](https://docs.docker.com/compose/install/)

## Deploy ecosystem stack

Step 1: Clone the repository and checkout usecase

```shell
$ > git clone https://github.com/naddym/nifi-course-abm.git
$ > cd templates/pushing-to-elasticsearch
```

Step 2: Deploy stack with docker-compose

```shell
$ > sudo docker-compose up -d
```

## Access ElasticSearch/Kibana from NiFi

ElasticSearch would be running on port `9200` and Kibana on port `5601`, please use the same port when configuring the elasticsearch processor.