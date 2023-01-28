Download the template `Multipart-File-Upload-And-Database-Insertion` and upload into NiFi instance

### Creating following table in database

It is imperative that the following table structure be established within the database for trying out the above template

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

### Upload a file attachment while calling REST API

To upload a file attachment using the HandleHTTPRequest processor in the above template, please download the [regions.csv](./regions.csv) file and use it during the call.