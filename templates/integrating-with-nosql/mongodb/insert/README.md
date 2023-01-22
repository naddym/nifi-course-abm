Download the template and upload into NiFi instance

### Configuring Processors

***GenerateFlowFile*** 

Configuring `GenerateFlowFile` processor is simple. Just copy below data to `Custom Text` property of GenerateFlowFile Processor

```json
{
  "id" : 6523,
  "ident" : "00A",
  "type" : "heliport",
  "name" : "Total Rf Heliport",
  "latitude_deg" : 40.0708,
  "longitude_deg" : -74.93360137939453,
  "elevation_ft" : 11,
  "continent" : "NA",
  "iso_country" : "US",
  "iso_region" : "US-PA",
  "municipality" : "Bensalem",
  "scheduled_service" : "yes",
  "gps_code" : "00A",
  "iata_code" : null,
  "local_code" : "00A",
  "home_link" : null,
  "wikipedia_link" : null,
  "keywords" : null
}
```

***PutMongo***

| Name | Value |
| ---- | ----- |
| Mongo URI | `mongodb://nifi:password@ec2-34-229-218-152.compute-1.amazonaws.com:27017` |
| Mongo Database Name | `test` |
| Mongo Collection Name | `nifi` |
| Mode | `insert` |