# Setting Up PostgreSQL docker on your machine

In order to try out example of Mongodb, you need to have it up and running. I have demonstrated the example by spinning up a docker image of mongodb and mongodb express client. You can replicate that or install alternative way which ever feels the best. If you have chosen alternative way, please ignore below setup

## Prerequisites
* Install [Docker](https://www.docker.com/)
* Install [Docker Compose](https://docs.docker.com/compose/install/)

## Deploy ecosystem stack

Step 1: Clone the repository and checkout usecase

```shell
$ > git clone https://github.com/naddym/nifi-course-abm.git
$ > cd templates/integrating-with-nosql/mongodb
```

Step 2: Deploy stack with docker-compose

```shell
$ > sudo docker-compose up -d
```

## Access Mongodb from NiFi

Mongodb would be running on port `27017` and to interact with mongodb with UI, I'm using mongodb express which can access on port `8081`, please use `27017` port for accessing mongodb from mongo processors.