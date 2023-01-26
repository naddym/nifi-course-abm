Download the template and upload into NiFi instance


### Postgres Table Schema

Before making use of the example, ensure you have following table schema created in your database

```shell
$ > CREATE TABLE AIRPORTS (
    ID INT PRIMARY KEY NOT NULL,
    IDENT TEXT NOT NULL,
    TYPE TEXT NOT NULL,
    NAME TEXT NOT NULL,
    LATITUDE_DEG DECIMAL,
    LONGITUDE_DEG DECIMAL,
    ELEVATION_FT INT,
    CONTINENT TEXT,
    ISO_COUNTRY TEXT,
    ISO_REGISON TEXT,
    MUNICIPALITY TEXT,
    SCHEDULED_SERVICE TEXT,
    GPS_CODE TEXT,
    IATA_CODE TEXT,
    LOCAL_CODE TEXT,
    HOME_LINK TEXT,
    KEYWORDS TEXT,
    FREQUENCY_MHZ TEXT
);
```

### Configuring Processors and Controller Services

***GenerateFlowFile*** 

Configuring `GenerateFlowFile` processor is simple. Just copy below data to `Custom Text` property of GenerateFlowFile Processor

```json
{
    "id": 40814,
    "ident": "SK-377",
    "type": "small_airport",
    "name": "Barbosa Airport",
    "latitude_deg": 5.943333,
    "longitude_deg": -73.611389,
    "elevation_ft": 5176,
    "continent": "SA",
    "iso_country": "CO",
    "iso_region": "CO-SAN",
    "municipality": "Barbosa",
    "scheduled_service": "no",
    "gps_code": null,
    "iata_code": null,
    "local_code": "BSA",
    "home_link": null,
    "wikipedia_link": null,
    "keywords": null,
    "frequency_mhz": "121.9"
}
```

***PutDatabaseRecord***

| Name | Value |
| ---- | ----- |
| Record Reader | `Create a new JsonTreeReader Controller Service` |
| Database Type | `PostgreSQL` |
| Statement Type | `UPSERT` |
| Database Connection Pooling Service | `Create a new DBCPConnectionPool Controller Service` |
| Table Name | `airports` |

***JsonTreeReader*** Controller Service

No additional configuration is required, just enable the controller service

***DBCPConnectionPool*** Controller Service

| Name | Value |
| ---- | ----- |
| Database Connection URL | `jdbc:postgresql://localhost:5432/postgres` |
| Database Driver Class Name | `org.postgresql.Driver` |
| Database Driver Location(s) | `/home/nadeem/driver/postgresql-42.2.2.jar` |
| Database User | `postgres` |
| Password | `postgres` |

### Verifying the database

Change type from `small_airport` to `heliport` and verify that upsert operation only changed the type column of the airports table

```shell
$ > select id,ident,type,name from airports;
```