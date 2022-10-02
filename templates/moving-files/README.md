Download the template and upload into NiFi instance

Before running the template, it is important to create files in a directory `/home/nadeem/Documents`

```shell
# change directory
$ > cd /home/nadeem/Documents

# create directories if does not exist
$ > mkdir -p get-file put-file

# change directory to get-file
$ > cd get-file

# create file
$ > echo "Hello, world! from A" > data.txt
```

### Configuring Processors

***GetFile***

| Name | Value |
| ---- | ----- |
| Input Directory | `/home/nadeem/Documents/get-file` |

***PutFile***

| Name | Value |
| ---- | ----- |
| Input Directory | `/home/nadeem/Documents/put-file` |

