Download the template and upload into NiFi instance

### Configuring Processors

***GenerateFlowFile*** 

Configuring `GenerateFlowFile` processor is simple. Just copy below data to `Custom Text` property of GenerateFlowFile Processor

```json
{
 "id" : 6522
}
```

***DeleteMongo***

| Name | Value |
| ---- | ----- |
| Mongo URI | `mongodb://nifi:password@ec2-34-229-218-152.compute-1.amazonaws.com:27017` |
| Mongo Database Name | `test` |
| Mongo Collection Name | `nifi` |