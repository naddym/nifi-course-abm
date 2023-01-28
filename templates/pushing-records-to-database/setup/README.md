# Setting Up PostgreSQL docker on your machine

This guide will take you through the process of trying out the `INSERT` and `UPSERT` operations mentioned above. To do this, you'll need to have a database running. I've provided an example using a PostgreSQL database running in a Docker container, but you can use any setup that works for you. If you choose to use an alternative setup, simply disregard the instructions for setting up the Docker container.

## Prerequisites
* Install [Docker](https://www.docker.com/)
* Install [Docker Compose](https://docs.docker.com/compose/install/)

## Deploy ecosystem stack

Step 1: Clone the repository and checkout usecase

```shell
$ > git clone https://github.com/naddym/nifi-course-abm.git
$ > cd templates/pushing-records-to-database
```

Step 2: Deploy stack with docker-compose

```shell
$ > sudo docker-compose up -d
```

## Access PostgreSQL Database from NiFi

PostgreSQL database would be running on port `5432`, please use the same port when configuring the controller service.

