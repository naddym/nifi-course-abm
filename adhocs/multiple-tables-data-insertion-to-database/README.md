Download the template `Multipart-File-Upload-And-Database-Insertion` and upload into NiFi instance

### Creating following table in database

It is imperative that the following table structures be established within the database for trying out the above template

```shell
CREATE TABLE AIRPORT_REGIONS (
    ID INT PRIMARY KEY NOT NULL,
    CODE TEXT NOT NULL,
    LOCAL_CODE TEXT,
    NAME TEXT,
    CONTINENT TEXT,
    ISO_COUNTRY TEXT,
    WIKIPEDIA_LINK TEXT,
    KEYWORDS TEXT
);
```

```shell
CREATE TABLE CUSTOMERS (
    ID INT PRIMARY KEY NOT NULL,
    NAME VARCHAR(50) NOT NULL,
    AGE INT NOT NULL,
    ADDRESS TEXT NOT NULL,
    ZIPCODE INT NOT NULL
);
```