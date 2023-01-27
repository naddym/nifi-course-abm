Download the template `Data-From-Rest-API-To-Database-Upsert.xml` and upload into NiFi instance

### Running Customer REST API Server

(customer-rest-api-server)[./customer-rest-api-server] is a simple sprint-boot rest api server for serving customers (CRUD)


### Creating following table in database

The above spring-boot application returns data in following table structure format. It is expected that below table schema should be created in the database

```shell
CREATE TABLE CUSTOMERS (
    ID INT PRIMARY KEY NOT NULL,
    NAME VARCHAR(50) NOT NULL,
    AGE INT NOT NULL,
    ADDRESS TEXT NOT NULL,
    ZIPCODE INT NOT NULL
);
```