Download the template and upload into NiFi instance

### Configuring Processors

***GetMongo***

| Name | Value |
| ---- | ----- |
| Mongo URI | `mongodb://nifi:password@ec2-34-229-218-152.compute-1.amazonaws.com:27017` |
| Mongo Database Name | `test` |
| Mongo Collection Name | `nifi` |
| Query| `{ "id" : 6522 } |