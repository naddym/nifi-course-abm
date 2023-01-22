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
[
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
    },
    {
        "id": 342103,
        "ident": "ZYXW",
        "type": "closed",
        "name": "Mt Logan Airstrip",
        "latitude_deg": 60.79299,
        "longitude_deg": -138.694027,
        "elevation_ft": 1997,
        "continent": "NA",
        "iso_country": "CA",
        "iso_region": "CA-YT",
        "municipality": "Unorganized Yukon",
        "scheduled_service": "no",
        "gps_code": "ZYXW",
        "iata_code": "ZYA",
        "local_code": "YK90",
        "home_link": null,
        "wikipedia_link": null,
        "keywords": null,
        "frequency_mhz": "140.2"
    },
    {
        "id": 317861,
        "ident": "ZYYK",
        "type": "medium_airport",
        "name": "Yingkou Lanqi Airport",
        "latitude_deg": 40.542524,
        "longitude_deg": 122.3586,
        "elevation_ft": null,
        "continent": "AS",
        "iso_country": "CN",
        "iso_region": "CN-21",
        "municipality": "Laobian, Yingkou",
        "scheduled_service": "yes",
        "gps_code": "ZYYK",
        "iata_code": "YKH",
        "local_code": null,
        "home_link": null,
        "wikipedia_link": "https://en.wikipedia.org/wiki/Yingkou_Lanqi_Airport",
        "keywords": null,
        "frequency_mhz": "189.9"
    },
    {
        "id": 6099,
        "ident": "SKAR",
        "type": "medium_airport",
        "name": "El Eden Airport",
        "latitude_deg": 4.45278,
        "longitude_deg": -75.7664,
        "elevation_ft": 3990,
        "continent": "SA",
        "iso_country": "CO",
        "iso_region": "CO-QUI",
        "municipality": "Armenia",
        "scheduled_service": "yes",
        "gps_code": "SKAR",
        "iata_code": "AXM",
        "local_code": "AXM",
        "home_link": null,
        "wikipedia_link": "https://en.wikipedia.org/wiki/El_Ed%C3%A9n_Airport",
        "keywords": null,
        "frequency_mhz": "90.8"
    }
]
```

***PutDatabaseRecord***

| Name | Value |
| ---- | ----- |
| Record Reader | `Create a new JsonTreeReader Controller Service` |
| Database Type | `PostgreSQL` |
| Statement Type | `INSERT` |
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