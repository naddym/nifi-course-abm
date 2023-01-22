Download the template and upload into NiFi instance

### Configuring Processors

***GenerateFlowFile*** 

Configuring `GenerateFlowFile` processor is simple.

Dynamic properties

| Name | Value |
| ---- | ----- |
| dynamodb.item.hash.key.value | `6522` |

***GetDynamoDB***

| Name | Value |
| ---- | ----- |
| Table Name | `nifi-test` |
| Hash Key Name | `id` |
| Hash Key Value | `${dynamodb.item.hash.key.value}` |
| Region | `US East (N. Virginia)` |
| Json Document attribute | `data` |
| Access Key ID | `provide the access key id` |
| Secret Access Key | `provide the secret access key` |